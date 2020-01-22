package com.example.assignment1_danielgelfand;

import androidx.annotation.VisibleForTesting;

import java.util.ArrayList;
import java.util.Random;

public class Course {

    private static int courseID = 0;
    private String courseTitle;
    private String allassingmentsletter;
    private String allassingmentsnumber;
    private int totalGrade;

    public String getAllassingmentsletter() {
        return allassingmentsletter;
    }

    public void setAllassingmentsletter(String allassingmentsletter) {
        this.allassingmentsletter = allassingmentsletter;
    }

    public String getAllassingmentsnumber() {
        return allassingmentsnumber;
    }

    public void setAllassingmentsnumber(String allassingmentsnumber) {
        this.allassingmentsnumber = allassingmentsnumber;
    }

    public int getTotalGrade() {
        return totalGrade;
    }

    public void setTotalGrade(int totalGrade) {
        this.totalGrade = totalGrade;
    }

    public String getTotalGradeLetter() {
        return totalGradeLetter;
    }

    public void setTotalGradeLetter(String totalGradeLetter) {
        this.totalGradeLetter = totalGradeLetter;
    }

    private String totalGradeLetter;


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
