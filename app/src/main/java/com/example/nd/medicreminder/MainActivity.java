package com.example.nd.medicreminder;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageButton;

import com.example.nd.medicreminder.R;


public class MainActivity extends AppCompatActivity {

    ImageButton AddButton,AllMedButton,Allmedwithtime,settingbutton,calendarbtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        AddButton = (ImageButton) findViewById(R.id.AddButton);
        AddButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent myIntent = new Intent(MainActivity.this,
                        NewMedicine.class);
                startActivity(myIntent);
            }
        });

        AllMedButton = (ImageButton) findViewById(R.id.PillsButton);
        AllMedButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent newIntent = new Intent(MainActivity.this,
                        AllMedicines.class);
                startActivity(newIntent);
            }
        });
        Allmedwithtime = (ImageButton) findViewById(R.id.AlarmButton);
        Allmedwithtime.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent newIntent = new Intent(MainActivity.this,
                        AllMedicinesTime.class);
                startActivity(newIntent);
            }
        });

        calendarbtn = (ImageButton) findViewById(R.id.calendarButton);
        calendarbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent newIntent = new Intent(MainActivity.this,
                        calendarEvents.class);
                startActivity(newIntent);

            }
        });

    }

}
