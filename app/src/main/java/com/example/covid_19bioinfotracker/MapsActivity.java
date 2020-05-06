package com.example.covid_19bioinfotracker;

import androidx.core.content.ContextCompat;
import androidx.fragment.app.FragmentActivity;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.Log;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptor;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MapStyleOptions;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

import java.util.ArrayList;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    private static final String TAG = "";
    private GoogleMap mMap;
    ArrayList<LatLng> location=new ArrayList<>();
    final LatLng p1 = new LatLng(28.738250,77.091450);
    final LatLng p2 = new LatLng(28.566371,77.202445);
    final LatLng p3 = new LatLng(28.537320,77.283690);
    final LatLng p4 = new LatLng(28.642780,77.190740);
    final LatLng p5 = new LatLng(28.568730,77.201320);
    final LatLng p6 = new LatLng(28.422920,77.313000);
    final LatLng p7 = new LatLng(28.634440,77.095880);
    final LatLng p8= new LatLng(28.558170,77.200220);
    final LatLng p9 = new LatLng(28.673353,77.113225);
    final LatLng p10 = new LatLng(23.019311,72.555);
    final LatLng p11 = new LatLng(23.0202,72.5592);
    final LatLng p12 = new LatLng(21.183655,72.814409);
    final LatLng p13 = new LatLng(23.019900,72.560622);
//    final LatLng ranchi = new LatLng(23.3441, 85.3096);
//    final LatLng bengaluru = new LatLng(12.9716, 77.5646);
//    final LatLng triru = new LatLng(8.5241, 76.9366);
//    final LatLng bhopal = new LatLng(23.2599, 77.4126);
//    final LatLng mumbai = new LatLng(19.0760, 72.8777);
//    final LatLng imphal = new LatLng(24.8170, 93.9368);
//    final LatLng shillong = new LatLng(25.5788, 91.8933);
//    final LatLng aizawl = new LatLng(23.7307, 92.7173);
//    final LatLng chandigarh = new LatLng(30.7333, 76.7794);
//    final LatLng jaipur = new LatLng(26.9124, 75.7873);
//    final LatLng gangtok = new LatLng(27.3314, 88.6138);
//    final LatLng chennai = new LatLng(13.0827, 80.2707);
//    final LatLng hyderabad = new LatLng(17.3850, 78.4867);
//    final LatLng agartala = new LatLng(23.8315, 91.2868);
//    final LatLng lucknow = new LatLng(26.8467, 80.9462);
//    final LatLng dehradun = new LatLng(30.3165, 78.0322);

    ArrayList<String> places=new ArrayList<String>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
        location.add(p1);
        location.add(p2);
        location.add(p3);
        location.add(p4);
        location.add(p5);
        location.add(p6);
        location.add(p7);
        location.add(p8);
        location.add(p9);
        location.add(p10);
        location.add(p11);
        location.add(p12);
        location.add(p13);
//        location.add(ranchi);
//        location.add(bengaluru);
//        location.add(triru);
//        location.add(bhopal);
//        location.add(mumbai);
//        location.add(imphal);
//        location.add(shillong);
//        location.add(aizawl);
//        location.add(chandigarh);
//        location.add(jaipur);
//        location.add(gangtok);
//        location.add(chennai);
//        location.add(hyderabad);
//        location.add(agartala);
//        location.add(lucknow);
//        location.add(dehradun);
        places.add("Lal Path Labs, Block-E, Sector 18, Rohini,Delhi");
        places.add("Laboratory Services, Indraprastha Apollo Hospitals, Sarita Vihar,Delhi");
        places.add("Max  Lab, Max  Super  Speciality Hospital, Saket,Delhi");
        places.add("Sir Ganga Ram Hospital Clinical Lab Services,Delhi");
        places.add("Oncquest Labs Ltd, 3-Factory Road,Delhi");
        places.add("Prognosis Laboratories, 515-16, Sector 19, Dwarka,Delhi");
        places.add("City  X-Ray & Scan Clinic Pvt Ltd, 4B/18, Tilak Nagar,Delhi");
        places.add("Lifeline Laboratory, H-11, Green Park Extension,Delhi");
        places.add("Dept of Laboratory Services, Action Cancer Hospital, A-4, Paschim Vihar,Delhi");
        places.add("Unipath Specialty Laboratory Limited, 102, Sanoma Plaza,  Opposite Parimal  Garden, Ahmedabad,Gujarat");
        places.add("Supratech Micropath Laboratory & Research Institute Pvt Ltd, Kedar,Gujarat");
        places.add("SN GeneLab Pvt  Ltd, Nanpura, Surat,Gujarat");
        places.add("Pangenomics  International  Pvt Ltd, Ahmedabad,Gujarat");
//        places.add("Jharhand");
//        places.add("Karnataka");
//        places.add("Kerala");
//        places.add("Madhya Pradesh");
//        places.add("Maharashtra");
//        places.add("Manipur");
//        places.add("Meghalaya");
//        places.add("Mizoram");
//        places.add("Punjab");
//        places.add("Rajasthan");
//        places.add("Sikkim");
//        places.add("Tamil Naidu");
//        places.add("Telangana");
//        places.add("Tripura");
//        places.add("Uttar Pradesh");
//        places.add("Uttarkhand");
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

        // Add a marker in Sydney and move the camera
        LatLng india = new LatLng(20.5937, 78.9629);
        for (int i=0;i<location.size();i++)
        {
            mMap.addMarker(new MarkerOptions().position(location.get(i)).title(String.valueOf(places.get(i))).icon(bitmapDescriptorFromVector(getApplicationContext(),R.drawable.ic_local_hospital)));

        }
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(india,4.0f));
//        mMap.setOnMarkerClickListener(new GoogleMap.OnMarkerClickListener() {
//            @Override
//            public boolean onMarkerClick(Marker marker) {
//                String  mark=marker.getTitle();
//                Intent intent=new Intent(getApplicationContext(),UserDetails.class);
//                intent.putExtra("places",mark);
//                startActivity(intent);
//
//                return false;
//            }
//        });


    }
    private BitmapDescriptor bitmapDescriptorFromVector(Context context,int vectorResId){
        Drawable vectorDrawble= ContextCompat.getDrawable(context,vectorResId);
        vectorDrawble.setBounds(0,0,vectorDrawble.getIntrinsicWidth(),vectorDrawble.getIntrinsicHeight());
        Bitmap bitmap=Bitmap.createBitmap(vectorDrawble.getIntrinsicWidth(),vectorDrawble.getIntrinsicHeight(),Bitmap.Config.ARGB_8888);
        Canvas canvas=new Canvas(bitmap);
        vectorDrawble.draw(canvas);
        return BitmapDescriptorFactory.fromBitmap(bitmap);
    }
}
