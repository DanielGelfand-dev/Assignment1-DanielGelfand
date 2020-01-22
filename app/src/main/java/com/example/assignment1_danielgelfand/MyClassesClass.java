package com.example.assignment1_danielgelfand;

import android.widget.LinearLayout;
import android.widget.ListView;

import java.util.List;

public class MyClassesClass {

    String coursename;
    String assignment;
    String asstotal;

    public MyClassesClass(String coursename, String assignment, String asstotal) {
        this.coursename = coursename;
        this.assignment = assignment;
        this.asstotal = asstotal;
    }

    public String getCoursename() {
        return coursename;
    }

    public void setCoursename(String coursename) {
        this.coursename = coursename;
    }

    public String getAssignment() {
        return assignment;
    }

    public void setAssignment(String assignment) {
        this.assignment = assignment;
    }

    public String getAsstotal() {
        return asstotal;
    }

    public void setAsstotal(String asstotal) {
        this.asstotal = asstotal;

    }
    public void clearClasses()
    {
        coursename=null;
        assignment=null;
        asstotal=null;
    }
}
