package com.example.covid_19bioinfotracker;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class AppFeatures extends AppCompatActivity {

    Button warnBtn;
    TextView warnTxt;
    FirebaseAuth firebaseAuth;
    FirebaseUser firebaseUser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_app_features);
        warnBtn=findViewById(R.id.warnBtn);
        warnTxt=findViewById(R.id.warnTxt);
//        firebaseUser=firebaseAuth.getCurrentUser();
//        if (!firebaseUser.isEmailVerified()){
//            warnTxt.setVisibility(View.VISIBLE);
//            warnBtn.setVisibility(View.VISIBLE);
//            warnBtn.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View v) {
////                   final FirebaseUser fUser=firebaseAuth.getCurrentUser();
//                    firebaseUser.sendEmailVerification().addOnSuccessListener(new OnSuccessListener<Void>() {
//                        @Override
//                        public void onSuccess(Void aVoid) {
//                            Toast.makeText(AppFeatures.this, "Email has been verified", Toast.LENGTH_SHORT).show();
//                        }
//                    }).addOnFailureListener(new OnFailureListener() {
//                        @Override
//                        public void onFailure(@NonNull Exception e) {
//                            Toast.makeText(AppFeatures.this, "onfailure:"+e.getMessage(), Toast.LENGTH_SHORT).show();
//                        }
//                    });
//
//                }
//            });
//        }
    }

    public void itemWorkerLocation(View view) {
        Intent intent=new Intent(getApplicationContext(),LaborLocationActivity.class);
        startActivity(intent);
    }

//    public void itemProfile(View view) {
//        Intent intent=new Intent(getApplicationContext(),UserProfile.class);
//        startActivity(intent);
//    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.item_menu,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId()==R.id.help){
            Intent intent=new Intent(getApplicationContext(),HelpLine.class);
            startActivity(intent);
        }
        if (item.getItemId()==R.id.logout){
            FirebaseAuth.getInstance().signOut();
            finish();
            Intent intent=new Intent(getApplicationContext(),UserDetails.class);
            startActivity(intent);
        }

        if (item.getItemId()==R.id.add)
        {
            Intent intent=new Intent(getApplicationContext(),AddActivity.class);
            startActivity(intent);
        }

        if (android.R.id.home==item.getItemId())
            finish();
        return super.onOptionsItemSelected(item);
    }

    public void clkFund(View view) {
        Intent intent=new Intent(getApplicationContext(),FundActivity.class);
        startActivity(intent);
    }

    public void clkLab(View view) {
        Intent intent=new Intent(getApplicationContext(),LocationDetectionActivity.class);
        startActivity(intent);
    }

    public void clkTracker(View view) {
        Intent intent=new Intent(getApplicationContext(),TrackerActivity.class);
        startActivity(intent);
    }

    public void clkNewsUpdate(View view) {
        Intent intent=new Intent(getApplicationContext(),NewsPortalActivity.class);
        startActivity(intent);
    }

    public void clkSymptoms(View view) {
        Intent intent=new Intent(AppFeatures.this,SymptomActivity.class);
        startActivity(intent);
    }

    public void clkFAQ(View view) {
        Intent intent=new Intent(AppFeatures.this,FaqActivity.class);
        overridePendingTransition(android.R.anim.fade_in,android.R.anim.fade_out);
        startActivity(intent);
    }

    public void clkCondition(View view) {
        Intent intent=new Intent(AppFeatures.this,ConditionActivity.class);
        startActivity(intent);
    }

    public void clkGeofence(View view) {
        Intent intent=new Intent(AppFeatures.this,GeofencingActivity.class);
        startActivity(intent);
    }

    public void clkCommunity(View view) {
        Intent intent=new Intent(AppFeatures.this,CommunityActivity.class);
        startActivity(intent);
    }

    public void clkChatting(View view) {
        Intent intent=new Intent(AppFeatures.this,SigninChatsActivity.class);
        startActivity(intent);
    }
}
