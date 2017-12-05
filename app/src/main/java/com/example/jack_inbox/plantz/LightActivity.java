// Found how to do the light sensor code from:
// http://android-er.blogspot.com/2012/08/determine-light-level-sensortypelight.html


package com.example.jack_inbox.plantz;

import android.app.Activity;
import android.content.AsyncQueryHandler;
import android.content.Intent;
import android.hardware.Sensor;
import android.hardware.SensorManager;
import android.icu.text.DecimalFormat;
import android.support.v4.view.GestureDetectorCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.widget.SeekBar;
import android.widget.TextView;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;


public class LightActivity extends AppCompatActivity
{
    // Creates two text views
    TextView textLIGHT_available, textLIGHT_reading;
    private GestureDetectorCompat gestureObject;
    private SeekBar seekBar;
    private TextView textView;
    private double seekBarProgress = 1.0;
    private double currentLux = 1.0;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lights);


        // Sets textLight_available to the text view in the XML called LIGHT_available
        textLIGHT_available
                = (TextView) findViewById(R.id.LIGHT_available);
        // Sets textLight_reading to the text view in the XML called LIGHT_reading
        textLIGHT_reading
                = (TextView) findViewById(R.id.lightSensorValue);

        // Gets the system sensor in the device setting it  equal to mySensorManager
        SensorManager mySensorManager = (SensorManager) getSystemService(SENSOR_SERVICE);
        // Gets the Sensor.TYPE_LIGHT and sets it equal to LightSensor
        Sensor LightSensor = mySensorManager.getDefaultSensor(Sensor.TYPE_LIGHT);


        // Checks if LightSensor has a value
        if (LightSensor != null) { // If LightSensor does have a value, display this message
            // Sets rate at which the LightSensor data is retrieved from the device
            mySensorManager.registerListener(
                    LightSensorListener,
                    LightSensor,
                    SensorManager.SENSOR_DELAY_NORMAL); // Default rate

        } else { // If LightSensor does not have a value, display this message
            textLIGHT_available.setText("An Error has occurred when trying to access LIGHT SENSOR!");
        }

       seekBar = (SeekBar) findViewById(R.id.seekBar);
            textView = (TextView) findViewById(R.id.count);
            // Add listener to SeekBar
        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {

                public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {

                    seekBarProgress = progress + 50;
                    seekBarProgress = seekBarProgress * 0.02;
                    textView.setText("Multiplier: " + String.format("%.2f",seekBarProgress));

                }

            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            public void onStopTrackingTouch(SeekBar seekBar) {
            }
        });

        gestureObject = new GestureDetectorCompat(this, new LearnGesture());
    }


    // Creates a Listener event for the Light Sensor
   private final SensorEventListener LightSensorListener
            = new SensorEventListener() {

        // Called when the accuracy values of the registered sensor has changed.
        // Changes when there is a new accuracy value
        @Override
        public void onAccuracyChanged(Sensor sensor, int accuracy) {

        }

        // Called when a new sensor event occurs. Changes when a new reading comes from
        // the sensor of the device.
        @Override
        public void onSensorChanged(SensorEvent event) {
            if (event.sensor.getType() == Sensor.TYPE_LIGHT) {
                currentLux = event.values[0];
                currentLux = currentLux * seekBarProgress;
                textLIGHT_reading.setText("LUX: " + String.format("%.2f", currentLux));
            }
        }


    };


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