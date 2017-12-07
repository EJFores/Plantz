package com.example.jack_inbox.plantz;

import android.content.Intent;
import android.support.v4.view.GestureDetectorCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class WeatherActivity extends AppCompatActivity
{

    public static String city;

    Button click;
    public static TextView data;
    public static EditText cityinput;


    private GestureDetectorCompat gestureObject;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_weatheract);

        click = (Button) findViewById(R.id.button);
        data = (TextView) findViewById(R.id.weather);
        cityinput = (EditText) findViewById(R.id.cityInput);

        weatherData process = new weatherData();
        process.execute();

        final Button planttest = (Button) findViewById(R.id.planttest);
        planttest.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                if ((weatherData.weather >= FetchPlantData.fweather) && (weatherData.weather <= FetchPlantData.f2weather)){
                    Toast.makeText(WeatherActivity.this, "PASSED", Toast.LENGTH_SHORT).show();
                    Log.d("Weahter", + weatherData.weather + " fetched data" + FetchPlantData.fweather+ " fetched data 2" + FetchPlantData.f2weather);
                }
                else {
                    Log.d("weather", "failedcheck weather" + weatherData.weather + " fetched data:" + FetchPlantData.fweather+ " fetched data 2:" + FetchPlantData.f2weather);
                    Toast.makeText(WeatherActivity.this, "FAILED", Toast.LENGTH_SHORT).show();
                }
            }
        });



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
                               float velocityX, float velocityY){

            if(event2.getX() > event1.getX())
            {
                Intent intent = new Intent(
                        WeatherActivity.this, LightActivity.class);
                finish();
                startActivity(intent);


            }
            else if (event2.getX() < event1.getX())
            {
                Intent intent = new Intent(
                        WeatherActivity.this, MapsActivity.class);
                finish();
                startActivity(intent);

            }
            return true;

        }


    }
}
