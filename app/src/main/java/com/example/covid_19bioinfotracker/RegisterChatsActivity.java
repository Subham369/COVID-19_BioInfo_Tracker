package com.example.covid_19bioinfotracker;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;

public class RegisterChatsActivity extends AppCompatActivity {

    private EditText regName,regEmail,regPhone,regPassword;
    private FirebaseAuth firebaseAuth;
    private DatabaseReference databaseReference;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_chats);
        regName=findViewById(R.id.regName);
        regEmail=findViewById(R.id.regEmail);
        regPhone=findViewById(R.id.regPhone);
        regPassword=findViewById(R.id.regPassword);
        firebaseAuth=FirebaseAuth.getInstance();
    }

    public void chattingRegister(View view) {
        String chatName=regName.getText().toString();
        String chatEmail=regEmail.getText().toString();
        String chatPhone=regPhone.getText().toString();
        String chatPassword=regPassword.getText().toString();

        if (TextUtils.isEmpty(chatName)){
            regName.requestFocus();
            regName.setError("Please enter your name");
            return;
        }

        if (TextUtils.isEmpty(chatEmail)){
            regEmail.requestFocus();
            regEmail.setError("Please enter your email address");
            return;
        }

        if (TextUtils.isEmpty(chatPhone)|| chatPhone.length()<10){
            regPhone.requestFocus();
            regPhone.setError("Please enter valid phone number");
            return;
        }

        if (TextUtils.isEmpty(chatPassword)|| chatPassword.length()<6){
            regPassword.requestFocus();
            regPassword.setError("Please enter a valid password");
            return;
        }
        registerChatAccount(chatName,chatEmail,chatPhone,chatPassword);

    }

    private void registerChatAccount(final String chatName, String chatEmail, final String chatPhone, String chatPassword) {
        firebaseAuth.createUserWithEmailAndPassword(chatEmail,chatPassword).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if (task.isSuccessful()){
                    FirebaseUser firebaseUser=firebaseAuth.getCurrentUser();
                    String chatId=firebaseUser.getUid();
                    databaseReference= FirebaseDatabase.getInstance().getReference("UserChat").child(chatId);
                    HashMap<String,String> hashMap=new HashMap<>();
                    hashMap.put("id", chatId);
                    hashMap.put("username", chatName);
                    hashMap.put("imageURL", "default");
                    hashMap.put("status","offline");
                    hashMap.put("search",chatName.toLowerCase());

                    databaseReference.setValue(hashMap).addOnCompleteListener(new OnCompleteListener<Void>() {
                        @Override
                        public void onComplete(@NonNull Task<Void> task) {
                            if (task.isSuccessful()){
                                Toast.makeText(RegisterChatsActivity.this, "Registration Successful", Toast.LENGTH_SHORT).show();
                                Intent intent=new Intent(RegisterChatsActivity.this,SigninChatsActivity.class);
                                startActivity(intent);
                            }
                            else
                                Toast.makeText(RegisterChatsActivity.this, "Registration failed please try again", Toast.LENGTH_SHORT).show();
                        }
                    }).addOnFailureListener(new OnFailureListener() {
                        @Override
                        public void onFailure(@NonNull Exception e) {
                            Toast.makeText(RegisterChatsActivity.this, "Error :"+e.getMessage(), Toast.LENGTH_SHORT).show();
                        }
                    });
                }
            }
        });
    }
}
