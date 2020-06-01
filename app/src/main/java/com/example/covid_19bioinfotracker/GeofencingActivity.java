package com.example.covid_19bioinfotracker;

import androidx.annotation.NonNull;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.FragmentActivity;

import android.Manifest;
import android.app.PendingIntent;
import android.content.pm.PackageManager;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.google.android.gms.location.Geofence;
import com.google.android.gms.location.GeofencingClient;
import com.google.android.gms.location.GeofencingRequest;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.CircleOptions;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;
import java.util.List;

public class GeofencingActivity extends FragmentActivity implements OnMapReadyCallback , GoogleMap.OnMapLongClickListener{

    private GoogleMap mMap;
    private GeofencingClient geofencingClient;
    private int FINE_LOCATION_ACCESS_REQUEST_CODE=10001;
    private float GEOFENCE_RADIUS=200;
    private GeofenceHelper geofenceHelper;
    private String GEOFENCE_ID="GEOFENCE_ID";
    private static final String TAG = "MapsActivity";
    private int requestCode=10002;
    private List<LatLng> dangerousArea;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_geofencing);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
        geofencingClient= LocationServices.getGeofencingClient(this);
        geofenceHelper=new GeofenceHelper(this);
    }


    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;
        enableLocation();
        mMap.setOnMapLongClickListener(this);
    }

    private void enableLocation() {
        if (ContextCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) == PackageManager.PERMISSION_GRANTED){
            mMap.setMyLocationEnabled(true);
        }
        else
        {
            if (ActivityCompat.shouldShowRequestPermissionRationale(this,Manifest.permission.ACCESS_FINE_LOCATION)){
                ActivityCompat.requestPermissions(this,new String[]{Manifest.permission.ACCESS_FINE_LOCATION},FINE_LOCATION_ACCESS_REQUEST_CODE);
            }
            else
            {
                ActivityCompat.requestPermissions(this,new String[]{Manifest.permission.ACCESS_FINE_LOCATION},FINE_LOCATION_ACCESS_REQUEST_CODE);
            }
        }
    }

    @Override
    public void onRequestPermissionsResult(int request, @NonNull String[] permissions, @NonNull int[] grantResults) {
        if(request==FINE_LOCATION_ACCESS_REQUEST_CODE){
            if (grantResults.length>0 && grantResults[0]==PackageManager.PERMISSION_GRANTED){
                mMap.setMyLocationEnabled(true);
            }
            else
            {

            }
        }

        if(request==requestCode){
            if (grantResults.length>0 && grantResults[0]==PackageManager.PERMISSION_GRANTED){
                Toast.makeText(this, "You can add geofences", Toast.LENGTH_SHORT).show();
            }
            else
            {
                Toast.makeText(this, "Background location is necessary for adding geofences", Toast.LENGTH_SHORT).show();
            }
        }
    }

    @Override
    public void onMapLongClick(LatLng latLng) {

        if (Build.VERSION.SDK_INT>=29){
            if (ContextCompat.checkSelfPermission(this,Manifest.permission.ACCESS_BACKGROUND_LOCATION)==PackageManager.PERMISSION_GRANTED){
                handLongClick(latLng);
            }
            else
            {
                if (ActivityCompat.shouldShowRequestPermissionRationale(this,Manifest.permission.ACCESS_BACKGROUND_LOCATION)){
                    ActivityCompat.requestPermissions(this,new String[]{Manifest.permission.ACCESS_BACKGROUND_LOCATION},requestCode);
                }
                else
                {
                    ActivityCompat.requestPermissions(this,new String[]{Manifest.permission.ACCESS_BACKGROUND_LOCATION},requestCode);
                }
            }
        }
        else{
            handLongClick(latLng);
        }
    }
    private void handLongClick(LatLng latLng){
        mMap.clear();
        addMarker(latLng);
        addCircle(latLng,GEOFENCE_RADIUS);
        addGeofence(latLng,GEOFENCE_RADIUS);
    }

    private void addGeofence(LatLng latLng,float radius){

        Geofence geofence=geofenceHelper.getGeofence(GEOFENCE_ID,latLng,radius,Geofence.GEOFENCE_TRANSITION_ENTER|Geofence.GEOFENCE_TRANSITION_DWELL|Geofence.GEOFENCE_TRANSITION_EXIT);
        GeofencingRequest geofencingRequest=geofenceHelper.geofencingRequest(geofence);
        PendingIntent pendingIntent=geofenceHelper.getPendingIntent();
        geofencingClient.addGeofences(geofencingRequest,pendingIntent).addOnSuccessListener(new OnSuccessListener<Void>() {
            @Override
            public void onSuccess(Void aVoid) {
                Log.d(TAG, "onSuccess: Geofence is added");
            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                String errorMessage=geofenceHelper.getErrorString(e);
                Log.d(TAG,"onFailure:"+errorMessage);
            }
        });
    }

    private void addMarker(LatLng latLng){
        MarkerOptions markerOptions=new MarkerOptions().position(latLng);
        mMap.addMarker(markerOptions);
    }

    private void addCircle(LatLng latLng,float radius){
        CircleOptions circleOptions=new CircleOptions();
        circleOptions.center(latLng);
        circleOptions.radius(radius);
        circleOptions.strokeColor(Color.argb(255,255,0,0));
        circleOptions.fillColor(Color.argb(64,255,0,0));
        circleOptions.strokeWidth(4f);
        mMap.addCircle(circleOptions);
    }
}
