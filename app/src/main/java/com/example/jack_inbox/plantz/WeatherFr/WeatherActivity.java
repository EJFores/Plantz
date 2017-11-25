package com.example.jack_inbox.plantz.WeatherFr;

import android.app.Activity;
import android.os.Bundle;
import android.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.jack_inbox.plantz.R;

public class WeatherActivity extends FragmentActivity
{

    public static String city;
    public static String st;

    Button click;
    public static TextView data;
    public static EditText cityinput;


    public View onCreate(LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState)
    {
        return inflater.inflate(
                R.layout.activity_weather, container, false);
    }

    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        Log.d("Fragment 6", "onCreate");
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
    public void onDestroy() {
        super.onDestroy();
        Log.d("Fragment 6", "onDestroy");
    }
}
