package com.example.assignment1_danielgelfand;

import androidx.annotation.VisibleForTesting;

import java.util.ArrayList;
import java.util.Random;

public class Course {

    private static int courseID = 0;
    private String courseTitle;
    private ArrayList<Assignment> assignments;

    private Course(String title, ArrayList<Assignment> assgn) {

        courseTitle = title;
        assignments = assgn;
        courseID++;
    }

    static public Course generateRandomCourse() {
        Random rnd = new Random();
        int assignmentNo = rnd.nextInt(5);
        ArrayList<Assignment> tempAssgn = new ArrayList<Assignment>();

        for (int i = 0; i < assignmentNo; i++) {

            tempAssgn.add(Assignment.generaterandomAssignment());
        }

        return new Course("Course" + courseID, tempAssgn);


    }

    public String getCourseTitle() {
        return courseTitle;
    }

    public ArrayList<Assignment> getAssignments() {
        return assignments;
    }
}
