package com.example.assignment1_danielgelfand;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
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


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);


        Toolbar myToolbar = findViewById(R.id.myToolBar); // set up the toolbar
        setSupportActionBar(myToolbar); // set our toolbar
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        setupUI();


        button_save.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                String name = textedit_name.getText().toString(); // get the name textbar's contents
                String age = textedit_age.getText().toString();
                String id = textedit_id.getText().toString();

                SharedPreferences sharedPreferences = getSharedPreferences(getString(R.string.user_name), Context.MODE_PRIVATE);
                SharedPreferences.Editor myEdit = sharedPreferences.edit();
                myEdit.putString(getString(R.string.user_name), name);
                myEdit.putString(getString(R.string.user_age), age.toString());
                myEdit.putString(getString(R.string.user_id), id.toString());
                myEdit.apply();

                textedit_name.setEnabled(false);
                textedit_age.setEnabled(false);
                textedit_id.setEnabled(false);
                button_save.setVisibility(View.INVISIBLE);
                // what happens on the click event
            }
        });


    }

    @Override
    protected void onStart() {
        super.onStart();
        SharedPreferences sharedPreferences = getSharedPreferences(getString(R.string.user_name), Context.MODE_PRIVATE);
        String name = sharedPreferences.getString(getString(R.string.user_name), null);
        String age = sharedPreferences.getString(getString(R.string.user_age), null);
        String id = sharedPreferences.getString(getString(R.string.user_id), null);
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

