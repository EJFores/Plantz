package com.example.jack_inbox.plantz.MapsFr;

import android.app.Activity;
import android.graphics.Camera;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.app.Fragment;
import android.util.Log;
import android.view.*;

import com.example.jack_inbox.plantz.R;
import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapView;
import com.google.android.gms.maps.MapsInitializer;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

//https://stackoverflow.com/questions/19353255/how-to-put-google-maps-v2-on-a-fragment-using-viewpager
//my precious....my precious.....THIEF THIEF! WE STOLES IT, WE STOLES IT FROM THEM. golem golem...
public class MapsActivity extends Fragment
{
    MapView mMapView;
    private GoogleMap googleMap;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        View rootView =  inflater.inflate(R.layout.activity_testing, container, false);

        mMapView = rootView.findViewById(R.id.mapView);
        mMapView.onCreate(savedInstanceState);
        mMapView.onResume();

        try
        {
            MapsInitializer.initialize(getActivity().getApplicationContext());
        }catch (Exception Petong)
        {
            Log.d("Fragment 1", "onCreateView-ITS ALL GONE PETE TONG, CALL NIXON, A DEAF WOMAN, AND A HIPPIE");
            Petong.printStackTrace();
        }

        mMapView.getMapAsync(new OnMapReadyCallback()
        {
            @Override
            public void onMapReady(GoogleMap gMan)
            {
                googleMap = gMan;
                //googleMap.setMyLocationEnabled(true);
                LatLng carbonil = new LatLng(37.709108, -89.220732);
                googleMap.addMarker(new MarkerOptions().position(carbonil).title("Le Title").snippet("Le Description"));
                CameraPosition cameraPosition = new CameraPosition.Builder().target(carbonil).zoom(12).build();
                googleMap.animateCamera((CameraUpdateFactory.newCameraPosition(cameraPosition)));
            }
        });
        return rootView;
    }

        @Override
        public void onAttach(Activity activity) {
            super.onAttach(activity);
            Log.d("Fragment 2", "onAttach");
        }

        @Override
        public void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            Log.d("Fragment 2", "onCreate");
        }

        @Override
        public void onActivityCreated(Bundle savedInstanceState) {
            super.onActivityCreated(savedInstanceState);
            Log.d("Fragment 2", "onActivityCreated");
        }

        @Override
        public void onStart() {
            super.onStart();
            Log.d("Fragment 2", "onStart");
        }

        @Override
        public void onResume() {
            super.onResume();
            Log.d("Fragment 2", "onResume");
        }

        @Override
        public void onPause() {
            super.onPause();
            Log.d("Fragment 2", "onPause");
        }

        @Override
        public void onStop() {
            super.onStop();
            Log.d("Fragment 2", "onStop");

        }
        @Override
        public void onDestroyView() {
            super.onDestroyView();
            Log.d("Fragment 2", "onDestroyView");
        }

        @Override
        public void onDestroy() {
            super.onDestroy();
            Log.d("Fragment 2", "onDestroy");
        }

        @Override
        public void onDetach() {
            super.onDetach();
            Log.d("Fragment 2", "onDetach");
        }

}