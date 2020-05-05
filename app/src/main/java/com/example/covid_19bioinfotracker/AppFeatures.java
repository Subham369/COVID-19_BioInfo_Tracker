package com.example.covid_19bioinfotracker;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;

public class AppFeatures extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_app_features);
    }

    public void itemWorkerLocation(View view) {
        Intent intent=new Intent(getApplicationContext(),MapsActivity.class);
        startActivity(intent);
    }

    public void itemProfile(View view) {
        Intent intent=new Intent(getApplicationContext(),UserProfile.class);
        startActivity(intent);
    }

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
        return super.onOptionsItemSelected(item);
    }

    public void clkFund(View view) {
        Intent intent=new Intent(getApplicationContext(),FundActivity.class);
        startActivity(intent);
    }
}
