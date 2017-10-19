package com.example.jack_inbox.plantz;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class WeatherActivity extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(
                R.layout.activity_weather, container, false);
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        Log.d("Fragment 6", "onAttach");
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d("Fragment 6", "onCreate");
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        Log.d("Fragment 6", "onActivityCreated");
    }

    @Override
    public void onStart() {
        super.onStart();
        Log.d("Fragment 6", "onStart");
    }

    @Override
    public void onResume() {
        super.onResume();
        Log.d("Fragment 6", "onResume");
    }

    @Override
    public void onPause() {
        super.onPause();
        Log.d("Fragment 6", "onPause");
    }

    @Override
    public void onStop() {
        super.onStop();
        Log.d("Fragment 6", "onStop");

    }
    @Override
    public void onDestroyView() {
        super.onDestroyView();
        Log.d("Fragment 6", "onDestroyView");
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.d("Fragment 6", "onDestroy");
    }

    @Override
    public void onDetach() {
        super.onDetach();
        Log.d("Fragment 6", "onDetach");
    }
}//cool
