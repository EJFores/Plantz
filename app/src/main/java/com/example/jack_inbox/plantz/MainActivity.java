//Start of Project
package com.example.jack_inbox.plantz;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;


public class MainActivity extends AppCompatActivity
{

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final Button button = (Button) findViewById(R.id.runtest);
        button.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                startActivity(new Intent(MainActivity.this, MapsActivity.class));
            }
        });

        final Button buttoncredits = (Button) findViewById(R.id.credit);
        buttoncredits.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                startActivity(new Intent(MainActivity.this, CreditsActivity.class));
            }
        });

        final Button buttonapi = (Button) findViewById(R.id.api);
        buttonapi.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, APILookupActivity.class));
            }
        });


        final Button buttonplant = (Button) findViewById(R.id.planttest);
        buttonplant.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, PlantTestActivity.class));
            }
        });

    }
}//cool
