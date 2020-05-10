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
    final LatLng p14 = new LatLng(28.489359,77.06172);
    final LatLng p15 = new LatLng(28.46619,77.02693);
    final LatLng p16 = new LatLng(28.509487,77.091730);
    final LatLng p17 = new LatLng(28.4903,77.06121);
    final LatLng p18 = new LatLng(28.43979,77.040952);
    final LatLng p19 = new LatLng(12.9650,77.5960);
    final LatLng p20 = new LatLng(12.9326,77.6851);
    final LatLng p21 = new LatLng(12.9761,77.72954);
    final LatLng p22 = new LatLng(12.8963,77.5995);
    final LatLng p23 = new LatLng(9.691792,76.2928);
    final LatLng p24 = new LatLng(11.2459,75.7986);
    final LatLng p25 = new LatLng(23.269,77.3082);
    final LatLng p26 = new LatLng(22.7264,75.8798);
    final LatLng p27 = new LatLng(19.075236,72.9998);
    final LatLng p28 = new LatLng(19.1363,72.83772);
    final LatLng p29 = new LatLng(19.08226,72.8856);
    final LatLng p30 = new LatLng(19.139255,73.00441);
    final LatLng p31 = new LatLng(19.17245,72.8458);
    final LatLng p32 = new LatLng(19.1877,72.8394);
    final LatLng p33 = new LatLng(19.195310,72.9485);
    final LatLng p34 = new LatLng(18.50455,73.81911);
    final LatLng p35 = new LatLng(19.236027,72.8565);
    final LatLng p36 = new LatLng(18.53363,73.87703);
    final LatLng p37 = new LatLng(18.51857,73.8344);
    final LatLng p38 = new LatLng(19.176138,72.953698);
    final LatLng p39 = new LatLng(19.1753,72.9524);
    final LatLng p40 = new LatLng(19.033766,72.8382);
    final LatLng p41 = new LatLng(20.30588,85.83165);
    final LatLng p42 = new LatLng(30.91386,75.8228);
    final LatLng p43 = new LatLng(31.6531,74.8874);
    final LatLng p44 = new LatLng(26.77031,75.85431);
    final LatLng p45 = new LatLng(26.84962,75.80938);
    final LatLng p46 = new LatLng(12.92473,79.1346);
    final LatLng p47 = new LatLng(13.0620,80.2542);
    final LatLng p48 = new LatLng(13.0489,80.266022);
    final LatLng p49 = new LatLng(13.0389,80.1419);
    final LatLng p50 = new LatLng(11.0005,76.96202);
    final LatLng p51 = new LatLng(13.006135,80.2481);
    final LatLng p52 = new LatLng(13.02179,80.1856);
    final LatLng p53 = new LatLng(13.0864,801871);
    final LatLng p54 = new LatLng(17.41667,78.4158);
    final LatLng p55 = new LatLng(17.435567,78.445525);
    final LatLng p56 = new LatLng(17.4248,78.4530);
    final LatLng p57 = new LatLng(17.4449,78.4693);
    final LatLng p58 = new LatLng(17.4741,78.3142);
    final LatLng p59 = new LatLng(17.4589,78.4735);
    final LatLng p60 = new LatLng(17.4423,78.4969);
    final LatLng p61 = new LatLng(17.5337,78.3927);
    final LatLng p62 = new LatLng(17.4153,78.447793);
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
        location.add(p14);
        location.add(p15);
        location.add(p16);
        location.add(p17);
        location.add(p18);
        location.add(p19);
        location.add(p20);
        location.add(p21);
        location.add(p22);
        location.add(p23);
        location.add(p24);
        location.add(p25);
        location.add(p26);
        location.add(p27);
        location.add(p28);
        location.add(p29);
        location.add(p30);
        location.add(p31);
        location.add(p32);
        location.add(p33);
        location.add(p34);
        location.add(p35);
        location.add(p36);
        location.add(p37);
        location.add(p38);
        location.add(p39);
        location.add(p40);
        location.add(p41);
        location.add(p42);
        location.add(p43);
        location.add(p44);
        location.add(p45);
        location.add(p46);
        location.add(p47);
        location.add(p48);
        location.add(p49);
        location.add(p50);
        location.add(p51);
        location.add(p52);
        location.add(p53);
        location.add(p54);
        location.add(p55);
        location.add(p56);
        location.add(p57);
        location.add(p58);
        location.add(p59);
        location.add(p60);
        location.add(p61);
        location.add(p62);
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
        places.add("SRL Limited,  Gurugram");
        places.add("Modern Diagnostic & Research Centre-Lab, Jawahar Nagar");
        places.add("Core   Diagnostics Gurgaon; MolQ Laboratory, Phase IV, Gurgaon");
        places.add("Pathkind  Diagnostics, Sec 18, Gurgaon");
        places.add("Department of Pathology and Laboratory Medicine, Medanta-The Medicity, Sector38, Gurgaon");
        places.add("Neuberg Anand Reference Laboratory, Anand Tower, Bengaluru");
        places.add("Cancyte Technologies, Bengaluru; Sakra World Hospital Lab Services, Devarabeesanahalli VArthur Hobli");
        places.add("Central Diagnostic Lab, Vydehi Institute of Medical Sciences and Research Centre, Bengaluru");
        places.add("Lab  Services, Apollo Hospitals, 154/11,  Bannerghatta Road, Bengaluru");
        places.add("DDRC SRL Diagnostics Pvt Ltd, Panampilly  Nagar, Ernakulam");
        places.add("MIMS Lab Services, Govindapuram, Kozhikode");
        places.add("Chirayu Medical  College and Hospital,  Bhopal  Indore Highway, Bhaisakhedi, Bhopal");
        places.add("Sampurna Sodani Diagnostic Clinic, LG-1,   MoryaCentre, 16/1 Race Course Road, Indore");
        places.add("Thyrocare Technologies  Limited, D37/1,  TTC  MIDC, Turbhe, Navi Mumbai");
        places.add("Suburban Diagnostics (India) Pvt Ltd, Andheri (W), Mumbai");
        places.add("Metropolis Healthcare Ltd, Kohinoor Mall, Mumbai");
        places.add("Sir HN Reliance Foundation Hospital and  Research Centre, Rabale, Navi Mumbai");
        places.add("SRL Limited, Goregaon, Mumbai");
        places.add("A.G. Diagnostics Pvt Ltd, Four Bungalows, Mumbai");
        places.add("InfeXn Laboratories Private Limited, Wagle Industrial Estate, Thane");
        places.add("Tata Memorial Centre Diagnostic Services, Kothrud, Pune");
        places.add("Jariwala  Lab &  Diagnostics LLP, Borivli (W), Mumbai");
        places.add("Ruby Hall Clinic, Sassoon Road, Pune");
        places.add("Metropolis Healthcare Limited, Bhandarkar Institute Road, Pune");
        places.add("Qualilife  Diagnostics, Balaji Arcade, Mulund (W), Mumbai");
        places.add("SRL Diagnostics-Dr. Avinash Phadke (SRL Diagnostics Pvt Ltd), Malad West, Mumbai");
        places.add("Department of  Laboratory Medicine-P.D Hinduja National Hospital and Medical  Research Centre, Mahim, Mumbai");
        places.add("Dept of Lab Services, Apollo Hospitals, Bhubaneswar");
        places.add("Department of Microbiology, Dayanand Medical College & Hospital, Tagore Nagar, Civil Lines, Ludhiana");
        places.add("Tuli Diagnostic Centre, MajithaRoad, Amritsar");
        places.add("Central Lab, The  Mahatma Gandhi  University of Medical Sciences and Technology, Tonk Road, Jaipur");
        places.add("Dr  B Lal Clinical  Lab  Pvt Ltd, Malviya Nagar, Jaipur");
        places.add("Dept of Clinical Virology, CMC, Vellore");
        places.add("Department of  Laboratory Services, Apollo Hospitals Enterprise Ltd, Chennai");
        places.add("Neuberg  Ehrlich Lab Pvt Ltd, Balaji Nagar, Chennai");
        places.add("Sri RamachandraMedical College & Research Institute, Porur, Chennai");
        places.add("Microbiology Lab, Veerakeralam Road, Coimbatore");
        places.add("YRG CARE, Taramani, Chennai");
        places.add("MIOT Hospitals -Dept of Lab Medicine, Manapakkam, Chennai");
        places.add("Madras Medical Mission Clinical Lab Services, Mogappair East, Chennai");
        places.add("Laboratory Services, Jubilee Hills, Hyderabad");
        places.add("Apollo Health and Lifestyle Limited,    Bowenpally, Secunderabad");
        places.add("Dr Remedies Labs Private Ltd, Punjagutta, Hyderabad");
        places.add("Pathcare Labs Pvt Ltd, Medchal, Hyderabad");
        places.add("American Institute of Pathology, Serilingampally, Hyderabad");
        places.add("Medcis Pathlabs India, New Bowenpally, Secunderabad");
        places.add("Department of  Lab Medicine, Alexander Road, Secunderabad");
        places.add("Biognosys Technologies (India), Medchal, Malkajgiri");
        places.add("Dept of Lab Medicine, Star Hospitals, Banjara Hills, Hyderabad");
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
            mMap.addMarker(new MarkerOptions().position(location.get(i)).title(String.valueOf(places.get(i))).icon(bitmapDescriptorFromVector(getApplicationContext(),R.drawable.ic_flag)));

        }
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(india,4.0f));

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
