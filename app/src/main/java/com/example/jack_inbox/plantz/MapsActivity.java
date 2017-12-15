package com.example.jack_inbox.plantz;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v4.view.GestureDetectorCompat;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.widget.Toast;

import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapView;
import com.google.android.gms.maps.MapsInitializer;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;

public class MapsActivity extends AppCompatActivity implements OnMapReadyCallback, LocationListener
{
    MapView mMapView;
    public GoogleMap googleMap;
    private LocationManager locationManager;
    public LatLng locLatLong;
    private static final long MIN_TIME = 400;
    private static final float MIN_DISTANCE = 1000;
    public static String longitude;
    public static String latitude;

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

        locationManager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);
    }

    public void onStart()
    {
        super.onStart();

        try
        {
            MapsInitializer.initialize(MapsActivity.this);
        }catch (Exception Petong)
        {
            Log.d("MapsActivity", "onCreateView-ITS ALL GONE PETE TONG, CALL NIXON, A DEAF WOMAN, AND A HIPPIE");
            Petong.printStackTrace();
        }

        mMapView.getMapAsync(this);
    }

    @Override
    public void onMapReady(GoogleMap gMan)
    {
        googleMap = gMan;
        googleMap.setMapType(GoogleMap.MAP_TYPE_NORMAL);

        if (ActivityCompat.checkSelfPermission(this,
                Manifest.permission.ACCESS_FINE_LOCATION) == PackageManager.PERMISSION_GRANTED)
        {
            googleMap.setMyLocationEnabled(true);
            locationManager.requestLocationUpdates(LocationManager.NETWORK_PROVIDER, MIN_TIME, MIN_DISTANCE, this);
            Location location = locationManager.getLastKnownLocation(LocationManager.NETWORK_PROVIDER);
            locLatLong =  new LatLng(location.getLatitude(), location.getLongitude());
            latitude = String.valueOf(location.getLatitude());
            longitude = String.valueOf(location.getLongitude());
            Log.d("locmang", "yep it got here it is returning the location of1 " + locLatLong);
        }
        else {
            //Not in api-23, no need to prompt
            locLatLong = new LatLng(37.7091282,-89.2206553);
                Log.d("locmang", "yep it got here it is returning the location of2 " + locLatLong);
            longitude = String.valueOf(37.7091282);
            latitude = String.valueOf(-89.2206553);
            googleMap.setMyLocationEnabled(false);
        }
        Log.d("locmang", "yep it got here it is returning the location of3 " + locLatLong);
       // googleMap.addMarker(new MarkerOptions().position(locLatLong).title("Le Title").snippet("Le Description"));
        CameraPosition cameraPosition = new CameraPosition.Builder().target(locLatLong).zoom(12).build();
        googleMap.animateCamera((CameraUpdateFactory.newCameraPosition(cameraPosition)));
    }

    @Override
    public void onLocationChanged(Location location) {
        locLatLong =  new LatLng(location.getLatitude(), location.getLongitude());
        CameraUpdate cameraUpdate = CameraUpdateFactory.newLatLngZoom(locLatLong, 10);
        googleMap.animateCamera(cameraUpdate);
        locationManager.removeUpdates(this);
        longitude = String.valueOf(location.getLongitude());
        latitude = String.valueOf(location.getLatitude());
    }

    @Override
    public void onStatusChanged(String provider, int status, Bundle extras)
    {
        Log.d("hello","onProviderEnabled");
        System.out.println("onProviderEnabled");
        System.out.println("privider:" + provider);
    }

    @Override
    public void onProviderEnabled(String provider)
    {
        Log.d("hello","onProviderEnabled");
        System.out.println("onProviderEnabled");
        System.out.println("privider:" + provider);
    }

    @Override
    public void onProviderDisabled(String provider)
    {
        Log.d("hello","onProviderEnabled");
        System.out.println("onProviderEnabled");
        System.out.println("privider:" + provider);
        Toast.makeText(MapsActivity.this, "FAILED", Toast.LENGTH_LONG).show();
    }

    @Override
    public void onResume() {
        super.onResume();
        mMapView.onResume();
    }

    @Override
    public void onPause() {
        super.onPause();
        mMapView.onPause();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        mMapView.onDestroy();
    }

    @Override
    public void onLowMemory()
    {
        super.onLowMemory();
        mMapView.onLowMemory();
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        this.gestureObject.onTouchEvent(event);
        return super.onTouchEvent(event);
    }

    class LearnGesture extends GestureDetector.SimpleOnGestureListener
    {

        @Override
        public boolean onFling(MotionEvent event1, MotionEvent event2,
                               float velocityX, float velocityY){

            if(event2.getX() > event1.getX())
            {
                Intent intent = new Intent(
                        MapsActivity.this, WeatherActivity.class);
                finish();
                startActivity(intent);
            }
            else if (event2.getX() < event1.getX())
            {


            }
            return true;

        }


    }

}
