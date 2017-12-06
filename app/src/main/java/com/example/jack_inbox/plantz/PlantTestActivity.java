package com.example.jack_inbox.plantz;

import java.util.ArrayList;
import java.util.List;
import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.TextView;
import android.support.v4.view.GestureDetectorCompat;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.content.SharedPreferences;


public class PlantTestActivity extends AppCompatActivity implements OnItemSelectedListener
{

    Spinner spinner;
    public static String plant;

    TextView data;
        @Override
        public void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
           setContentView(R.layout.activity_plant);

            data = (TextView) findViewById(R.id.textplant);

            spinner= (Spinner) findViewById(R.id.spinnerplant);

            ArrayAdapter adapter=ArrayAdapter.createFromResource(this,R.array.plants,android.R.layout.simple_spinner_item);
            spinner.setAdapter(adapter);
            spinner.setOnItemSelectedListener(this);



            //spinner.setOnItemSelectedListener(new OnItemSelectedListener)
        }




        @Override
        public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l){
            TextView myText= (TextView) view;
            Toast.makeText(this, "You Selected "+ myText.getText(), Toast.LENGTH_SHORT).show();

            plant = spinner.getSelectedItem().toString();

            data.setText(this.plant);

        }


        public void onNothingSelected(AdapterView<?> adapterView){


        }

        @Override
        public void onStart() {
            super.onStart();
        }

}