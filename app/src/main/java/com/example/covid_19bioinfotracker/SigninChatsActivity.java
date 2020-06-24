package com.example.covid_19bioinfotracker;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class SigninChatsActivity extends AppCompatActivity {

    private EditText useremail,password;
    private FirebaseAuth firebaseAuth;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signin_chats);

        useremail=findViewById(R.id.useremail);
        password=findViewById(R.id.password);
        firebaseAuth=FirebaseAuth.getInstance();
    }

    public void chatLogin(View view) {
        String uemail=useremail.getText().toString();
        String upassword=password.getText().toString();
        if (TextUtils.isEmpty(uemail)){
            useremail.setError("Please enter registered email");
            useremail.requestFocus();
        }

        if (TextUtils.isEmpty(upassword)){
            password.setError("Please enter registered email");
            password.requestFocus();
        }

        firebaseAuth.signInWithEmailAndPassword(uemail,upassword).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if (task.isSuccessful()){
                    Toast.makeText(SigninChatsActivity.this, "You have successfully logged in", Toast.LENGTH_SHORT).show();
                    Intent intent=new Intent(SigninChatsActivity.this,ChattingActivity.class);
                    startActivity(intent);
                }

                else{
                    Toast.makeText(SigninChatsActivity.this, "Login failed !!! ", Toast.LENGTH_SHORT).show();
                }
            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                Toast.makeText(SigninChatsActivity.this, "Error:"+e.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    public void chatsForgotPassword(View view) {
        final EditText resetMail=new EditText(view.getContext());
        AlertDialog.Builder passwordReset=new AlertDialog.Builder(view.getContext());
        passwordReset.setTitle("Reset Password");
        passwordReset.setMessage("Enter your email to receive reset link");
        passwordReset.setView(resetMail);
        passwordReset.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                String mail=resetMail.getText().toString();
                firebaseAuth.sendPasswordResetEmail(mail).addOnSuccessListener(new OnSuccessListener<Void>() {
                    @Override
                    public void onSuccess(Void aVoid) {
                        Toast.makeText(SigninChatsActivity.this, "Reset link has been sent to the entered email", Toast.LENGTH_SHORT).show();
                    }
                }).addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Toast.makeText(SigninChatsActivity.this, "Error!! Reset link not send:"+e.getMessage(), Toast.LENGTH_SHORT).show();

                    }
                });
            }
        });
        passwordReset.setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

            }
        });
        passwordReset.create().show();
    }

    public void chatsRegister(View view) {
        Intent intent=new Intent(SigninChatsActivity.this,RegisterChatsActivity.class);
        startActivity(intent);
    }
}
