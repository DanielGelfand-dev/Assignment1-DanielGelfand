package com.example.assignment1_danielgelfand;

import androidx.annotation.NonNull;

import java.util.Random;

public class Assignment {

    private static int assID = 0;
    private String gassignmentTitle;
    private int assignmentGrade;

    private Assignment(String title, int grade)
    {
        gassignmentTitle = title;
        assignmentGrade = grade;
        assID++;

    }

    static public Assignment generaterandomAssignment() {
        Random rnd = new Random();
        String tempTitle = "assingment " + assID;
        int tempGrade = rnd.nextInt(100) + 1;

        return new Assignment(tempTitle, tempGrade);
    }

    public String getAssignmentTitle() {return gassignmentTitle;}
    public int getAssignmentGrade() {return assignmentGrade;}




}


