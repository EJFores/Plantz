package com.example.jack_inbox.plantz;

import android.app.Activity;
import android.app.DatePickerDialog;
import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Switch;

import java.util.Calendar;

public class DateActivity extends Fragment {

    Switch autoDate;
    EditText date;
    DatePickerDialog datePickerDialog;
    final Calendar c = Calendar.getInstance();
    int mYear = c.get(Calendar.YEAR); // current year
    int mMonth = c.get(Calendar.MONTH); // current month
    int mDay = c.get(Calendar.DAY_OF_MONTH); // current day
    @Override
    public View onCreateView(LayoutInflater inflater,
                             @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.activity_date,container,false);

        // initiate the date picker and a button
        date = (EditText) v.findViewById(R.id.date);
        // perform click event on edit text
        date.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // calender class's instance and get current date , month and year from calender

                // date picker dialog
                datePickerDialog = new DatePickerDialog(getActivity(),
                        new DatePickerDialog.OnDateSetListener() {

                            @Override
                            public void onDateSet(DatePicker view, int year,
                                                  int monthOfYear, int dayOfMonth) {
                                // set day of month , month and year value in the edit text
                                date.setText((monthOfYear + 1) + "/"
                                        + (dayOfMonth) + "/" + year);

                            }
                        }, mYear, mMonth, mDay);
                datePickerDialog.show();
            autoDate.setChecked(false);}});

// For the Switch
        autoDate = (Switch)v.findViewById(R.id.autoDate);
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
                }
                else
                {
                    date.setText("");
                }
            }
        });
            return v;

    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        Log.d("Fragment 4", "onAttach");
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {



        super.onCreate(savedInstanceState);
        Log.d("Fragment 4", "onCreate");
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        Log.d("Fragment 4", "onActivityCreated");
    }

    @Override
    public void onStart() {
        super.onStart();
        Log.d("Fragment 4", "onStart");
    }

    @Override
    public void onResume() {
        super.onResume();
        Log.d("Fragment 4", "onResume");
    }

    @Override
    public void onPause() {
        super.onPause();
        Log.d("Fragment 4", "onPause");
    }

    @Override
    public void onStop() {
        super.onStop();
        Log.d("Fragment 4", "onStop");

    }
    @Override
    public void onDestroyView() {
        super.onDestroyView();
        Log.d("Fragment 4", "onDestroyView");
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.d("Fragment 4", "onDestroy");
    }

    @Override
    public void onDetach() {
        super.onDetach();
        Log.d("Fragment 4", "onDetach");
    }

}