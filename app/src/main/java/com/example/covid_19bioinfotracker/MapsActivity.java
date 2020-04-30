package com.example.covid_19bioinfotracker;

import androidx.fragment.app.FragmentActivity;

import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.util.Log;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MapStyleOptions;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

import java.util.ArrayList;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    private static final String TAG = "";
    private GoogleMap mMap;
    ArrayList<LatLng> location=new ArrayList<>();
    final LatLng bhubaneswar = new LatLng(20.2961, 85.8245);
    final LatLng new_delhi = new LatLng(28.6139, 77.2090);
    final LatLng kolkata = new LatLng(22.5726, 88.3639);
    final LatLng amravati = new LatLng(20.9320, 77.7523);
    final LatLng itanagar = new LatLng(27.0844, 93.6053);
    final LatLng dispur = new LatLng(26.1453, 91.7898);
    final LatLng patna = new LatLng(25.5941, 85.1376);
    final LatLng raipur = new LatLng(21.2514, 81.6296);
    final LatLng panaji = new LatLng(15.4909, 73.8278);
    final LatLng gandhinagar = new LatLng(23.2156, 72.6369);
    final LatLng haryana = new LatLng(29.0588, 76.0856);
    final LatLng shimla = new LatLng(31.1048, 77.1734);
    final LatLng srinagar = new LatLng(34.0837, 74.7973);
    final LatLng ranchi = new LatLng(23.3441, 85.3096);
    final LatLng bengaluru = new LatLng(12.9716, 77.5646);
    final LatLng triru = new LatLng(8.5241, 76.9366);
    final LatLng bhopal = new LatLng(23.2599, 77.4126);
    final LatLng mumbai = new LatLng(19.0760, 72.8777);
    final LatLng imphal = new LatLng(24.8170, 93.9368);
    final LatLng shillong = new LatLng(25.5788, 91.8933);
    final LatLng aizawl = new LatLng(23.7307, 92.7173);
    final LatLng chandigarh = new LatLng(30.7333, 76.7794);
    final LatLng jaipur = new LatLng(26.9124, 75.7873);
    final LatLng gangtok = new LatLng(27.3314, 88.6138);
    final LatLng chennai = new LatLng(13.0827, 80.2707);
    final LatLng hyderabad = new LatLng(17.3850, 78.4867);
    final LatLng agartala = new LatLng(23.8315, 91.2868);
    final LatLng lucknow = new LatLng(26.8467, 80.9462);
    final LatLng dehradun = new LatLng(30.3165, 78.0322);

    ArrayList<String> places=new ArrayList<String>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
        location.add(bhubaneswar);
        location.add(new_delhi);
        location.add(kolkata);
        location.add(amravati);
        location.add(itanagar);
        location.add(dispur);
        location.add(patna);
        location.add(raipur);
        location.add(panaji);
        location.add(gandhinagar);
        location.add(haryana);
        location.add(shimla);
        location.add(srinagar);
        location.add(ranchi);
        location.add(bengaluru);
        location.add(triru);
        location.add(bhopal);
        location.add(mumbai);
        location.add(imphal);
        location.add(shillong);
        location.add(aizawl);
        location.add(chandigarh);
        location.add(jaipur);
        location.add(gangtok);
        location.add(chennai);
        location.add(hyderabad);
        location.add(agartala);
        location.add(lucknow);
        location.add(dehradun);
        places.add("Odisha");
        places.add("New Delhi");
        places.add("West Bengal");
        places.add("Andra Pradesh");
        places.add("Arunachal Pradesh");
        places.add("Assam");
        places.add("Bihar");
        places.add("Chattisgarh");
        places.add("Goa");
        places.add("Gujarat");
        places.add("Haryana");
        places.add("Himachal Pradesh");
        places.add("Jammu and Kashmir");
        places.add("Jharhand");
        places.add("Karnataka");
        places.add("Kerala");
        places.add("Madhya Pradesh");
        places.add("Maharashtra");
        places.add("Manipur");
        places.add("Meghalaya");
        places.add("Mizoram");
        places.add("Punjab");
        places.add("Rajasthan");
        places.add("Sikkim");
        places.add("Tamil Naidu");
        places.add("Telangana");
        places.add("Tripura");
        places.add("Uttar Pradesh");
        places.add("Uttarkhand");
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
//        try {
//            // Customise the styling of the base map using a JSON object defined
//            // in a raw resource file.
////            boolean success = googleMap.setMapStyle(
////                    MapStyleOptions.loadRawResourceStyle(this,R.r));
//
//            boolean success=googleMap.setMapStyle(MapStyleOptions.loadRawResourceStyle(MapsActivity.this,R.raw.))
//            if (!success) {
//                Log.e("MapsActivity", "Style parsing failed.");
//            }
//        } catch (Resources.NotFoundException e) {
//            Log.e("MapsActivity", "Can't find style. Error: ", e);
//        }

        // Add a marker in Sydney and move the camera
        LatLng india = new LatLng(20.5937, 78.9629);
       for (int i=0;i<location.size();i++)
       {
               mMap.addMarker(new MarkerOptions().position(location.get(i)).title(String.valueOf(places.get(i))));

       }
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(india,4.0f));
       mMap.setOnMarkerClickListener(new GoogleMap.OnMarkerClickListener() {
           @Override
           public boolean onMarkerClick(Marker marker) {
               String  mark=marker.getTitle();
                   Intent intent=new Intent(getApplicationContext(),UserDetails.class);
                   intent.putExtra("places",mark);
                   startActivity(intent);

               return false;
           }
       });
    }
}
