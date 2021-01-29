package com.project.smartparking;

import android.os.Bundle;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;

public class Map extends AppCompatActivity implements OnMapReadyCallback {
    private GoogleMap mMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_map);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);


    }
    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        // Add a marker in Sydney and move the camera
        LatLng rsyogyakarta = new LatLng(-7.8258245, 110.3759474);
        mMap.addMarker(new MarkerOptions().position(rsyogyakarta).title("Parkir RS Yogyakarta"));
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(rsyogyakarta, 13));

        LatLng rsugria = new LatLng(-7.8385917, 110.3636379);
        mMap.addMarker(new MarkerOptions().position(rsugria).title("Parkir RSU Griya Mahardika Yogyakata"));
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(rsugria, 13));

        LatLng abu = new LatLng(-7.7900445, 110.3654116);
        mMap.addMarker(new MarkerOptions().position(abu).title("Parkir ABU BAKAR ALI Yogyakata"));
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(abu, 13));

    }


}
