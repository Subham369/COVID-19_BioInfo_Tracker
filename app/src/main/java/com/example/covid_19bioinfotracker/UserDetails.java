package com.example.covid_19bioinfotracker;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class UserDetails extends AppCompatActivity {
    private TextView info;
    private FirebaseAuth firebaseAuth;
    private EditText mEmail,mPassword;
    Button btnLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_details);
        info=findViewById(R.id.info);
//        String place= getIntent().getStringExtra("places");
//        info.setText(place);
        firebaseAuth=FirebaseAuth.getInstance();
        mEmail=findViewById(R.id.edtmEmail);
        mPassword=findViewById(R.id.edtmPassword);
        btnLogin=findViewById(R.id.btnLogin);
    }

    public void clkLogin(View view) {
        String email=mEmail.getText().toString();
        String password=mPassword.getText().toString();

        if (TextUtils.isEmpty(email)){
            mEmail.setError("Enter a valid phone number");
            mEmail.requestFocus();
        }

        if (TextUtils.isEmpty(password)||password.length()<8){
            mPassword.setError("Enter a valid password");
            mPassword.requestFocus();
        }

        firebaseAuth.signInWithEmailAndPassword(email,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if (task.isSuccessful()){
                    Toast.makeText(UserDetails.this, "Login Successful", Toast.LENGTH_SHORT).show();
                    Intent intent=new Intent(getApplicationContext(),AppFeatures.class);
                    startActivity(intent);
                }
            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                Toast.makeText(UserDetails.this,e.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });

    }

    public void clkSignUp(View view) {
        Intent intent=new Intent(getApplicationContext(),UserSignup.class);
        startActivity(intent);
    }

//    @Override
//    public void onStart() {
//        super.onStart();
//        // Check if user is signed in (non-null) and update UI accordingly.
//        FirebaseUser currentUser = firebaseAuth.getCurrentUser();
//        updateUI(currentUser);
//    }
//
//    private void updateUI(FirebaseUser currentUser) {
//        Intent intent=new Intent(getApplicationContext(),AppFeatures.class);
//        startActivity(intent);
//    }
}
