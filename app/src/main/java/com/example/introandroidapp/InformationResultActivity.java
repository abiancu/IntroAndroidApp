package com.example.introandroidapp;

import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class InformationResultActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_information_result);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        /*INTENT TO RETRIEVE INFO FROM OTHER ACTIVITY*/
        Intent intent = getIntent();
        String season = intent.getStringExtra("season");
        int temperature = intent.getIntExtra("temperature", 70); // if no value exist, display default value
        String allergies = intent.getStringExtra("allergies");
        TextView txtSeason = findViewById(R.id.txtSeason);
        TextView txtTemp = findViewById(R.id.txtTemperature);
        TextView txtAllergies = findViewById(R.id.txtAllergies);

        txtSeason.setText(R.string.seasonResult + " " + season);
        txtTemp.setText(R.string.seasonTemp + temperature);

        if(allergies.equals("Yes"))
            txtAllergies.setText(R.string.allResultYes);
        else
            txtAllergies.setText(R.string.allResultNO);


        /*BUTTON TO GO BACK*/
        Button btnMain = findViewById(R.id.btnMain);
        btnMain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goMain();
            }

        });

    }

    private void goMain(){

        Intent intent = new Intent(InformationResultActivity.this, MainMenuActivity.class);
        this.startActivity(intent);

    }



}
