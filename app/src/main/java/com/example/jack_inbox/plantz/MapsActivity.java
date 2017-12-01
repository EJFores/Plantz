package com.example.jack_inbox.plantz;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Camera;
import android.os.Bundle;
import android.support.v4.view.GestureDetectorCompat;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.*;

import com.example.jack_inbox.plantz.R;
import com.google.android.gms.maps.*;
import com.google.android.gms.maps.model.*;

//https://stackoverflow.com/questions/19353255/how-to-put-google-maps-v2-on-a-fragment-using-viewpager
//my precious....my precious.....THIEF THIEF! WE STOLES IT, WE STOLES IT FROM THEM. golem golem...
public class MapsActivity extends AppCompatActivity
{
    MapView mMapView;
    public GoogleMap googleMap;

    private GestureDetectorCompat gestureObject;

    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mapsact);

        gestureObject = new GestureDetectorCompat(this, new LearnGesture());

        mMapView = (MapView) findViewById(R.id.mapView);
        mMapView.onCreate(savedInstanceState);
        mMapView.onResume();

        try
        {
            MapsInitializer.initialize(MapsActivity.this);
        }catch (Exception Petong)
        {
            Log.d("MapsActivity", "onCreateView-ITS ALL GONE PETE TONG, CALL NIXON, A DEAF WOMAN, AND A HIPPIE");
            Petong.printStackTrace();
        }

        mMapView.getMapAsync(new OnMapReadyCallback()
        {
            @Override
            public void onMapReady(GoogleMap gMan)
            {
                googleMap = gMan;
                googleMap.setMapType(GoogleMap.MAP_TYPE_NORMAL);
                //googleMap.setMyLocationEnabled(true);
                LatLng carbonil = new LatLng(37.709108, -89.220732);
                googleMap.addMarker(new MarkerOptions().position(carbonil).title("Le Title").snippet("Le Description"));
                CameraPosition cameraPosition = new CameraPosition.Builder().target(carbonil).zoom(12).build();
                googleMap.animateCamera((CameraUpdateFactory.newCameraPosition(cameraPosition)));
            }
        });
        return googleMap;
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        this.gestureObject.onTouchEvent(event);
        return super.onTouchEvent(event);
    }

    class LearnGesture extends GestureDetector.SimpleOnGestureListener{

        @Override
        public boolean onFling(MotionEvent event1, MotionEvent event2,
                               float velocityX, float velocityY){

            if(event2.getX() > event1.getX())
            {
                Intent intent = new Intent(
                        MapsActivity.this, MainActivity.class);
                finish();
                startActivity(intent);
            }
            else if (event2.getX() < event1.getX())
            {
                Intent intent = new Intent(
                        MapsActivity.this, DateActivity.class);
                finish();
                startActivity(intent);
            }
            return true;

        }


    }

}