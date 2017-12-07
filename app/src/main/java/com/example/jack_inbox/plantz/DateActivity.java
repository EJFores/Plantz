package com.example.jack_inbox.plantz;

import android.app.Activity;
import android.app.DatePickerDialog;
import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.view.GestureDetectorCompat;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.GestureDetector;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.Toast;

import java.util.Calendar;

public class DateActivity extends AppCompatActivity
{
    private GestureDetectorCompat gestureObject;

    Switch autoDate;
    EditText date;
    DatePickerDialog datePickerDialog;
    final Calendar c = Calendar.getInstance();

    public static int dateNum;


    @Override
    public void onCreate(Bundle savedInstanceState)
    {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dateact);
        // initiate the date picker and a button
        date = (EditText) findViewById(R.id.date);
        // perform click event on edit text
        date.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // calender class's instance and get current date , month and year from calender
                final Calendar c = Calendar.getInstance();
                int mYear = c.get(Calendar.YEAR); // current year
                final int mMonth = c.get(Calendar.MONTH); // current month
                int mDay = c.get(Calendar.DAY_OF_MONTH); // current day
                // date picker dialog
                datePickerDialog = new DatePickerDialog(DateActivity.this,
                        new DatePickerDialog.OnDateSetListener()
                        {

                            @Override
                            public void onDateSet(DatePicker view, int year,
                                                  int monthOfYear, int dayOfMonth) {
                                // set day of month , month and year value in the edit text
                                date.setText((monthOfYear + 1) + "/"
                                        + (dayOfMonth) + "/" + year);

                                dateNum = Integer.parseInt((monthOfYear+1) +""+ dayOfMonth);
                                Log.d("datecheck", "datepicker is returning:" + dateNum);
                            }
                        }, mYear, mMonth, mDay);
                datePickerDialog.show();
                autoDate.setChecked(false);
            }
        });


// For the Switch
        autoDate = (Switch) findViewById(R.id.autoDate);
        autoDate.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean isChecked) {
                if (isChecked) {
                    Calendar c = Calendar.getInstance();
                    int year = c.get(Calendar.YEAR); // current year
                    int monthOfYear = c.get(Calendar.MONTH); // current month
                    int dayOfMonth = c.get(Calendar.DAY_OF_MONTH); // current day

                    date.setText((monthOfYear + 1) + "/"
                            + (dayOfMonth) + "/" + year);
                    dateNum = Integer.parseInt((monthOfYear+1) +""+ dayOfMonth);
                    Log.d("datecheck", "sysdate is returning:" + dateNum);
                }
                else
                {
                    date.setText("");
                }
            }
        });

        final Button planttest = (Button) findViewById(R.id.planttest);
        planttest.setOnClickListener(new View.OnClickListener() {
                                         @Override
                                         public void onClick(View view) {
                                             if ((dateNum >= FetchPlantData.ddate1) && (dateNum <= FetchPlantData.ddate2)) {
                                                 Toast.makeText(DateActivity.this, "PASSED", Toast.LENGTH_SHORT).show();
                                             }
                                             else
                                             {
                                                 Log.d("datecheck", "failedcheck datenum:" + dateNum + "ddate1:" + FetchPlantData.ddate1+ "ddate2" + FetchPlantData.ddate2);
                                                 Toast.makeText(DateActivity.this, "FAILED", Toast.LENGTH_SHORT).show();
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

    //public

    class LearnGesture extends GestureDetector.SimpleOnGestureListener{

        @Override
        public boolean onFling(MotionEvent event1, MotionEvent event2,
                               float velocityX, float velocityY){

            if(event2.getX() > event1.getX())
            {
                Intent intent = new Intent(
                        DateActivity.this, MainActivity.class);
                finish();
                startActivity(intent);
            }
            else if (event2.getX() < event1.getX())
            {
                Intent intent = new Intent(
                        DateActivity.this, LightActivity.class);
                finish();
                startActivity(intent);
            }
            return true;

        }


    }
}