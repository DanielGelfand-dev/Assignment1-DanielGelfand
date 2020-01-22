package com.example.assignment1_danielgelfand;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class gradeActivity extends AppCompatActivity {

    protected ListView listView;
    protected TextView textview;
    private static final String TAG = "GradeActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d(TAG, "onCreate: worked");
        setContentView(R.layout.activity_grade);
        ArrayList<MyClassesClass> courses = new ArrayList<>();

        listView = findViewById(R.id.grade_listview);
        textview = findViewById(R.id.assignments);
        String allassingments;
        int totalGrade;


        //create list array
        for(int j=0; j<5; j++) {

            Log.d(TAG, "onCreate: outterloop"+j);
            allassingments ="Assignments: \n";
            totalGrade=0;
            Course course = Course.generateRandomCourse();

            ArrayList<Assignment> assignments = course.getAssignments();

            for (int i = 0; i < assignments.size(); i++) {
                Log.d(TAG, "onCreate: innerloop");
                totalGrade=totalGrade+(int)(assignments.get(i).getAssignmentGrade());
                allassingments=allassingments+assignments.get(i).getAssignmentTitle()+"  : "+Integer.toString(assignments.get(i).getAssignmentGrade())+"\n";


            }
            if(assignments.size() >0) courses.add(new MyClassesClass("Course Title: "+course.getCourseTitle(),allassingments,"Total Grade : "+Integer.toString(totalGrade/assignments.size()) ));
            if(assignments.size() <=0) courses.add(new MyClassesClass("Course Title: "+course.getCourseTitle(),allassingments,"Total Grade : "+"NaN" ));



        }

         // add data to our classes class


        // create custom class adapter

        MyAdapter adapter = new MyAdapter(this,courses);
        //set adapter into listview

        listView.setAdapter(adapter);

        Toolbar myToolbar = findViewById(R.id.myToolBar); // set up the toolbar
        setSupportActionBar(myToolbar); // set our toolbar
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

    }




    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.menu_profile, menu);

        return true;
    }


    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if(item.getItemId() == android.R.id.home)
        {
            onBackPressed();
        }
        if (item.getItemId() == R.id.grades_convert) {
            //do stuff here for when you click edit

        }

        return true;
    }
}
