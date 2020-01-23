package com.example.assignment1_danielgelfand;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class profileActivity extends AppCompatActivity {

    protected EditText textedit_name;
    protected EditText textedit_age;
    protected EditText textedit_id;
    protected Button button_save;
    protected SharedPreferenceHelper sharedPreferenceHelper;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);


        Toolbar myToolbar = findViewById(R.id.myToolBar); // set up the toolbar
        setSupportActionBar(myToolbar); // set our toolbar
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        setupUI();
        sharedPreferenceHelper = new SharedPreferenceHelper(this);


        button_save.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {


                String name = textedit_name.getText().toString(); // get the name textbar's contents
                String age = textedit_age.getText().toString();
                String id = textedit_id.getText().toString();
                if ((TextUtils.isEmpty(textedit_name.getText().toString())) |
                        (TextUtils.isEmpty(textedit_id.getText().toString()))|
                (TextUtils.isEmpty(textedit_age.getText().toString())))
                {
                    Toast.makeText(profileActivity.this, "No Empty Fields Allowed", Toast.LENGTH_LONG).show();


                }
               else  if( (Integer.parseInt(textedit_age.getText().toString())) < (18)) {
                    Toast.makeText(profileActivity.this, "Age 18-99", Toast.LENGTH_LONG).show();
                }
               else{



                    sharedPreferenceHelper.saveProfileAge(age);
                    sharedPreferenceHelper.saveProfileID(id);
                    sharedPreferenceHelper.saveProfileName(name);

                    textedit_name.setEnabled(false);
                    textedit_age.setEnabled(false);
                    textedit_id.setEnabled(false);
                    button_save.setVisibility(View.INVISIBLE);
                    // what happens on the click event

                }

            }
        });


    }

    @Override
    protected void onStart() {
        super.onStart();
        sharedPreferenceHelper = new SharedPreferenceHelper(this);


        String name = sharedPreferenceHelper.getProfileName();
        String age = sharedPreferenceHelper.getProfileAge();
        String id = sharedPreferenceHelper.getProfileID();
        if (name != null) {
            textedit_name.setText(name);
            textedit_age.setText(age);
            textedit_id.setText(id);
            textedit_name.setEnabled(false);
            textedit_age.setEnabled(false);
            textedit_id.setEnabled(false);
            button_save.setVisibility(View.INVISIBLE);

        }
    }

    @Override
    public boolean onSupportNavigateUp() {
        Toast.makeText(profileActivity.this, "TESTING", Toast.LENGTH_SHORT).show();
        return true;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.menu_profile, menu);

        return true;
    }


    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            onBackPressed();
        }
        if (item.getItemId() == R.id.profile_edit) {
            //do stuff here for when you click edit
            textedit_name.setEnabled(true);
            textedit_age.setEnabled(true);
            textedit_id.setEnabled(true);
            button_save.setVisibility(View.VISIBLE);

        }


        return true;
    }


    protected void setupUI() {
        textedit_name = findViewById(R.id.editText_name);
        textedit_age = findViewById(R.id.editText_age);
        textedit_id = findViewById(R.id.editText_id);
        button_save = findViewById(R.id.button_save);

    }


}

