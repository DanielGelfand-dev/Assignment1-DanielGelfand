package com.example.assignment1_danielgelfand;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    protected Button button_name, button_grades;
    private static final String TAG = "MainActivity";

    protected SharedPreferenceHelper sharedPreferenceHelper;


    // String user_name = user_info.getString(getString(R.string.user_name),null);


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d(TAG, "onCreate: STARTED MAIN ");
        setContentView(R.layout.activity_main);

        Toolbar myToolbar = findViewById(R.id.myToolBar); // set up the toolbar
        setSupportActionBar(myToolbar); // set our toolbar


        setupUI(); // set up our buttons
        clearData(); // remove all previous values


        button_grades.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Log.d(TAG, "onClick: goingtogrades");
                goToGrades(); // what happens on the click event
            }
        });

        button_name.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                goToProfile(); // what happens on the click event
            }
        });


    }

    @Override
    protected void onStart() {
        super.onStart();
sharedPreferenceHelper =new SharedPreferenceHelper(this);
        String name =sharedPreferenceHelper.getProfileName();
        if (name == null) {
            goToProfile();
        }

        button_name.setText(name);
    }

    protected void goToGrades() {
        Intent intent = new Intent(this, gradeActivity.class);
        startActivity(intent);
    }

    protected void goToProfile() {
        Intent intent = new Intent(this, profileActivity.class);
        startActivity(intent);
    }

    protected void setupUI() {
        button_name = findViewById(R.id.button_name);
        button_grades = findViewById(R.id.button_grades);

    }

    protected void clearData() {
       sharedPreferenceHelper = new SharedPreferenceHelper(this);
        sharedPreferenceHelper.saveProfileName(null);
        sharedPreferenceHelper.saveProfileID("");
        sharedPreferenceHelper.saveProfileAge("");

    }


}
