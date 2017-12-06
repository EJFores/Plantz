package com.example.jack_inbox.plantz;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.support.v7.app.AppCompatActivity;

public class APILookupActivity extends AppCompatActivity
{
    Button click;
   public static TextView data;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_apilook);



        click = (Button) findViewById(R.id.button);
        data = (TextView) findViewById(R.id.fetchdata);

        click.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view){
                FetchPlantData process = new FetchPlantData();
                process.execute();

            }

        });


    }
}
//thing