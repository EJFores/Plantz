package com.example.jack_inbox.plantz;

import android.app.Activity;
import android.content.Intent;
import android.support.v4.view.GestureDetectorCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.GestureDetector;
import android.view.MotionEvent;


public class LightActivity extends AppCompatActivity
{
    private GestureDetectorCompat gestureObject;

    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lights);

        gestureObject = new GestureDetectorCompat(this, new LearnGesture());
    }
    @Override
    public boolean onTouchEvent(MotionEvent event) {
        this.gestureObject.onTouchEvent(event);
        return super.onTouchEvent(event);
    }

    class LearnGesture extends GestureDetector.SimpleOnGestureListener{

        @Override
        public boolean onFling(MotionEvent event1, MotionEvent event2,
                               float velocityX, float velocityY)
            {

            if(event2.getX() > event1.getX())
            {
                Intent intent = new Intent(
                        LightActivity.this, DateActivity.class);
                finish();
                startActivity(intent);
            }

            else if (event2.getX() < event1.getX())
            {
                Intent intent = new Intent(
                        LightActivity.this, WeatherActivity.class);
                finish();
                startActivity(intent);
            }
            return true;

        }


    }

}