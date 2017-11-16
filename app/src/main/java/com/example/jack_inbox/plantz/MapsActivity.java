package com.example.jack_inbox.plantz;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.app.Fragment;
import android.util.Log;
import android.view.*;
//import com.google.android.gms.maps.

public class MapsActivity extends Fragment
{

    @Override
    public View onCreateView(LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(
                R.layout.activity_maps, container, false);
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