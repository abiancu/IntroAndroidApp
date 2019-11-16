package com.example.introandroidapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

public class spinnerEx extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_spinner_ex);

        Spinner spinner = (Spinner) findViewById(R.id.mySpinner);

        //create the list option using Adapter
        ArrayAdapter<CharSequence> myList = ArrayAdapter.createFromResource(this,
                R.array.myOptions,
                android.R.layout.simple_spinner_item);

        //Select which layout to apply when the list appears
        myList.setDropDownViewResource(R.layout.support_simple_spinner_dropdown_item);

        //Apply the Adapter
        spinner.setAdapter(myList);
        spinner.setOnItemSelectedListener(this);
    }


    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        //to select the first item
        String item = parent.getItemAtPosition(position).toString();

        //Shows the selection as a
        Toast.makeText(parent.getContext(), item , Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}
