package com.example.jack_inbox.plantz;

import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by gregevans on 10/19/17.
 */

public class PlantTestActivity extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(
                R.layout.activity_runtest, container, false);
    }
        @Override
        public void onAttach(Activity activity) {
            super.onAttach(activity);
            Log.d("Fragment 3", "onAttach");
        }

        @Override
        public void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            Log.d("Fragment 3", "onCreate");
        }

        @Override
        public void onActivityCreated(Bundle savedInstanceState) {
            super.onActivityCreated(savedInstanceState);
            Log.d("Fragment 3", "onActivityCreated");
        }

        @Override
        public void onStart() {
            super.onStart();
            Log.d("Fragment 3", "onStart");
        }

        @Override
        public void onResume() {
            super.onResume();
            Log.d("Fragment 3", "onResume");
        }

        @Override
        public void onPause() {
            super.onPause();
            Log.d("Fragment 3", "onPause");
        }

        @Override
        public void onStop() {
            super.onStop();
            Log.d("Fragment 3", "onStop");

        }
        @Override
        public void onDestroyView() {
            super.onDestroyView();
            Log.d("Fragment 3", "onDestroyView");
        }

        @Override
        public void onDestroy() {
            super.onDestroy();
            Log.d("Fragment 3", "onDestroy");
        }

        @Override
        public void onDetach() {
            super.onDetach();
            Log.d("Fragment 3", "onDetach");
        }

}