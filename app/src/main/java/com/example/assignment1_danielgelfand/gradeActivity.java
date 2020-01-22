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
    protected int letterGrades=0;
    private static final String TAG = "GradeActivity";
    ArrayList<Course> allcourses = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // 0 sets letter grades off, 1 sets lettergrades on
        super.onCreate(savedInstanceState);
        Log.d(TAG, "onCreate: worked");
        setContentView(R.layout.activity_grade);

        listView = findViewById(R.id.grade_listview);
        textview = findViewById(R.id.assignments);


        String allassingmentsletter;
        String allassingmentsnumber;
        int totalGrade;
        String totalGradeLetter;
        int assignmentSize;

        ArrayList<MyClassesClass> courses = new ArrayList<>();

        //create list array
        for (int j = 0; j < 5; j++) {

            Log.d(TAG, "onCreate: outterloop" + j);
            allassingmentsletter = "Assignments: \n";
            allassingmentsnumber = "Assignments: \n";

            totalGrade = 0;
            totalGradeLetter = "";
            Course course = Course.generateRandomCourse();
            allcourses.add(course);
            ArrayList<Assignment> assignments = course.getAssignments();
            Log.d(TAG, "onCreate:going to innerloop" + assignments.size());
            assignmentSize = assignments.size();
            for (int i = 0; i < assignments.size(); i++) {
                Log.d(TAG, "onCreate: innerloop");
                totalGrade = totalGrade + (int) (assignments.get(i).getAssignmentGrade());

                allassingmentsnumber = allassingmentsnumber + assignments.get(i).getAssignmentTitle() + "  : " + Integer.toString(assignments.get(i).getAssignmentGrade()) + "\n";
                //  if(assignments.size() >0) courses.add(new MyClassesClass("Course Title: "+course.getCourseTitle(),allassingments,"Total Grade : "+Integer.toString(totalGrade/assignments.size()) ));
                //   if(assignments.size() <=0) courses.add(new MyClassesClass("Course Title: "+course.getCourseTitle(),allassingments,"Total Grade : "+"NaN" ));


                //we got an F
                if (assignments.get(i).getAssignmentGrade() < 50) {
                    //   Log.d(TAG, "onCreate: <50");
                    allassingmentsletter = allassingmentsletter + assignments.get(i).getAssignmentTitle() + "  : " + "F" + "\n";

                }
                if (assignments.get(i).getAssignmentGrade() >= 50 && assignments.get(i).getAssignmentGrade() <= 59) { //we got an D-
                    allassingmentsletter = allassingmentsletter + assignments.get(i).getAssignmentTitle() + "  : " + "D" + "\n";
                    //  Log.d(TAG, "onCreate: <60");
                }
                if (assignments.get(i).getAssignmentGrade() >= 60 && assignments.get(i).getAssignmentGrade() <= 69) { //we got an D-
                    allassingmentsletter = allassingmentsletter + assignments.get(i).getAssignmentTitle() + "  : " + "C" + "\n";
                    //   Log.d(TAG, "onCreate: <70");
                }
                if (assignments.get(i).getAssignmentGrade() >= 70 && assignments.get(i).getAssignmentGrade() <= 79) { //we got an D-
                    allassingmentsletter = allassingmentsletter + assignments.get(i).getAssignmentTitle() + "  : " + "B" + "\n";
                    //   Log.d(TAG, "onCreate: <80");
                }
                if (assignments.get(i).getAssignmentGrade() >= 80 && assignments.get(i).getAssignmentGrade() <= 100) { //we got an D-
                    allassingmentsletter = allassingmentsletter + assignments.get(i).getAssignmentTitle() + "  : " + "A" + "\n";
                    //   Log.d(TAG, "onCreate: 100");
                }


            }


            if (assignmentSize > 0) {
                Log.d(TAG, "onCreate: " + (totalGrade / assignmentSize));

                if ((totalGrade / assignmentSize) < 50) {
                    Log.d(TAG, "onCreate: F");
                    totalGradeLetter = "F";

                }
                if ((totalGrade / assignmentSize) >= 50 && (totalGrade / assignmentSize) <= 59) {
                    totalGradeLetter = "D";
                    Log.d(TAG, "onCreate: D");
                }
                if ((totalGrade / assignmentSize) >= 60 && (totalGrade / assignmentSize) <= 69) {
                    totalGradeLetter = "C";
                    Log.d(TAG, "onCreate: C");
                }
                if ((totalGrade / assignmentSize) >= 70 && (totalGrade / assignmentSize) <= 79) {
                    totalGradeLetter = "B";
                    Log.d(TAG, "onCreate: B");
                }
                if ((totalGrade / assignmentSize) >= 80 && (totalGrade / assignmentSize) <= 100) {
                    totalGradeLetter = "A";
                    Log.d(TAG, "onCreate: A");
                }
            }
            course.setAllassingmentsletter(allassingmentsletter);
            course.setAllassingmentsnumber(allassingmentsnumber);
            course.setTotalGrade(totalGrade);
            course.setTotalGradeLetter(totalGradeLetter);
            if (assignments.size() > 0)
                courses.add(new MyClassesClass("Course Title: " + course.getCourseTitle(), allassingmentsnumber, "Total Grade : " + Integer.toString(totalGrade / assignments.size())));
            if (assignments.size() <= 0)
                courses.add(new MyClassesClass("Course Title: " + course.getCourseTitle(), allassingmentsnumber, "Total Grade : " + "NaN"));

        }


        // add data to our classes class


        // create custom class adapter

        MyAdapter adapter = new MyAdapter(this, courses);
        //set adapter into listview

        listView.setAdapter(adapter);

        Toolbar myToolbar = findViewById(R.id.myToolBar); // set up the toolbar
        setSupportActionBar(myToolbar); // set our toolbar
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

    }

    @Override
    protected void onStart() {
        super.onStart();

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.menu_grades, menu);

        return true;
    }


    public void convertGrade() {
        listView = findViewById(R.id.grade_listview);
        ArrayList<MyClassesClass> courses = new ArrayList<>();


        for (int j = 0; j < 5; j++) {


            Course course = allcourses.get(j);

            ArrayList<Assignment> assignments = course.getAssignments();
            if (letterGrades == 0) {
                Log.d(TAG, "convertGrade: TO NUMBER");
                if (assignments.size() > 0)
                    courses.add(new MyClassesClass("Course Title: " + course.getCourseTitle(), course.getAllassingmentsnumber(), "Total Grade : " + Integer.toString(course.getTotalGrade() / assignments.size())));
                if (assignments.size() <= 0)
                    courses.add(new MyClassesClass("Course Title: " + course.getCourseTitle(), course.getAllassingmentsnumber(), "Total Grade : " + "NaN"));
            }
            if(letterGrades==1){
                Log.d(TAG, "convertGrade: TO LETTER");
                if (assignments.size() > 0)
                    courses.add(new MyClassesClass("Course Title: " + course.getCourseTitle(), course.getAllassingmentsletter(), "Total Grade : " +course.getTotalGradeLetter()));
                if (assignments.size() <= 0)
                    courses.add(new MyClassesClass("Course Title: " + course.getCourseTitle(), course.getAllassingmentsletter(), "Total Grade : " + "NaN"));

            }

        }
        MyAdapter adapter = new MyAdapter(this, courses);

        listView.setAdapter(adapter);


    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            onBackPressed();
        }
        if (item.getItemId() == R.id.grades_convert) {
            if (letterGrades == 1) {
                letterGrades = 0;
                convertGrade();
            }
            else {
                letterGrades = 1;
                convertGrade();
            }
        }

        return true;
    }
}
