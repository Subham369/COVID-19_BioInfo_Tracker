package com.example.covid_19bioinfotracker;

import androidx.annotation.NonNull;
        import androidx.annotation.Nullable;
        import androidx.annotation.RequiresApi;
        import androidx.appcompat.app.AppCompatActivity;

        import android.Manifest;
        import android.content.Intent;
        import android.content.pm.PackageManager;
        import android.location.Address;
        import android.location.Geocoder;
        import android.location.Location;
        import android.location.LocationListener;
        import android.location.LocationManager;
        import android.os.Build;
        import android.os.Bundle;
        import android.telephony.SmsManager;
        import android.view.View;
        import android.widget.AdapterView;
        import android.widget.ArrayAdapter;
        import android.widget.EditText;
        import android.widget.Spinner;
        import android.widget.Toast;

        import com.google.android.gms.common.ConnectionResult;
        import com.google.android.gms.common.api.GoogleApiClient;
        import com.google.android.gms.location.LocationRequest;
        import com.google.android.gms.maps.CameraUpdateFactory;
        import com.google.android.gms.maps.model.LatLng;
        import com.google.android.gms.maps.model.MarkerOptions;
        import com.google.android.gms.tasks.OnCompleteListener;
        import com.google.android.gms.tasks.Task;
        import com.google.android.gms.tasks.TaskExecutors;
        import com.google.firebase.FirebaseException;
        import com.google.firebase.auth.AuthResult;
        import com.google.firebase.auth.FirebaseAuth;
        import com.google.firebase.auth.FirebaseUser;
        import com.google.firebase.auth.PhoneAuthCredential;
        import com.google.firebase.auth.PhoneAuthProvider;
        import com.google.firebase.database.DatabaseReference;
        import com.google.firebase.database.FirebaseDatabase;

        import java.io.IOException;
        import java.util.ArrayList;
        import java.util.HashMap;
        import java.util.List;
        import java.util.concurrent.TimeUnit;

public class UserSignup extends AppCompatActivity {
    EditText edtPhone, edtOTP, edtName, edtDOB, edtEmail, edtPassword, edtAddress;
    Spinner spinner;
    private String verficationId;
    private FirebaseAuth firebaseAuth;
    private DatabaseReference databaseReference;
    LocationManager locationManager;
    private final long MIN_TIME = 1000;
    private final long MIN_DIST = 100;
    private int item_position=0;
    private String text="";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_signup);
        edtPhone = findViewById(R.id.edtPhone);
//        edtOTP = findViewById(R.id.edtOTP);
        edtName = findViewById(R.id.edtName);
        edtDOB = findViewById(R.id.edtDOB);
        edtEmail = findViewById(R.id.edtEmail);
        edtPassword = findViewById(R.id.edtPassword);
        edtAddress = findViewById(R.id.edtAddress);
        spinner = findViewById(R.id.spinner);
        firebaseAuth = FirebaseAuth.getInstance();

        ArrayList<String> coname = new ArrayList<>();
        coname.add("Enter the type of worker");
        coname.add("Hired Worker");
        coname.add("Causal Worker");
        coname.add("Regular Salaried Worker");
        coname.add("Self Employed");
        ArrayAdapter arrayAdapter = new ArrayAdapter(this, android.R.layout.simple_spinner_item, coname);
        arrayAdapter.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);
        spinner.setAdapter(arrayAdapter);

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                spinner.setSelection(position);
                text=parent.getItemAtPosition(position).toString();
                item_position=position;

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                spinner.requestFocus();

            }
        });
    }

    public void signUp(View view) {
            String medtName = edtName.getText().toString();
            String medtDOB = edtDOB.getText().toString();
            String medtPhone = edtPhone.getText().toString();
            String medtEmail = edtEmail.getText().toString();
            String medtPassword = edtPassword.getText().toString();
            String medtAddress = edtAddress.getText().toString();
            String mspinner=text;

            if (medtName.isEmpty()) {
                edtName.requestFocus();
                edtName.setError("Enter your name");
                return;
            }
            if (medtDOB.isEmpty()) {
                edtDOB.requestFocus();
                edtDOB.setError("Enter your date of birth");
                return;
            }
            if (medtPhone.isEmpty()) {
                edtPhone.requestFocus();
                edtPhone.setError("Enter your phone");
                return;
            }
            if (medtPassword.isEmpty() || medtPassword.length() < 6) {
                edtPassword.requestFocus();
                edtPassword.setError("Enter valid password with length greater than 6");
                return;
            }
            if (medtEmail.isEmpty()) {
                edtEmail.requestFocus();
                edtEmail.setError("Enter valid email address");
                return;
            }
            if (medtAddress.isEmpty()) {
                edtAddress.requestFocus();
                edtAddress.setError("Enter your current address");
                return;
            }

            if (mspinner.isEmpty()) {
                spinner.requestFocus();
                return;
            }
            register(medtName, medtDOB, medtPhone, medtEmail, medtPassword, medtAddress,mspinner);
    }

    private void register(final String medtName, final String medtDOB, final String medtPhone, final String medtEmail, String medtPassword, final String medtAddress, final String workInfo) {
        firebaseAuth.createUserWithEmailAndPassword(medtEmail, medtPassword).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if (task.isSuccessful()) {
                    FirebaseUser firebaseUser = firebaseAuth.getCurrentUser();
                    String userId = firebaseUser.getUid();
                    databaseReference = FirebaseDatabase.getInstance().getReference("userdetails").child(userId);
                    HashMap<String, String> hashMap = new HashMap<>();
                    hashMap.put("id", userId);
                    hashMap.put("username", medtName);
                    hashMap.put("dob", medtDOB);
                    hashMap.put("phone_number", medtPhone);
                    hashMap.put("email", medtEmail);
                    hashMap.put("address", medtAddress);
                    hashMap.put("occupation", workInfo);

                    databaseReference.setValue(hashMap).addOnCompleteListener(new OnCompleteListener<Void>() {
                        @Override
                        public void onComplete(@NonNull Task<Void> task) {
                            if (task.isSuccessful()) {
                                Intent intent = new Intent(getApplicationContext(), UserDetails.class);
                                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
                                startActivity(intent);
                                Toast.makeText(UserSignup.this, "Details saved successfully", Toast.LENGTH_LONG).show();
                            } else
                                Toast.makeText(UserSignup.this, task.getException().getMessage(), Toast.LENGTH_LONG).show();
                        }
                    });

                }
            }
        });
    }

}
