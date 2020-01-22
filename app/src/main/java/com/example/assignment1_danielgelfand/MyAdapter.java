package com.example.assignment1_danielgelfand;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;

public class MyAdapter extends BaseAdapter {

    Context con;
    ArrayList<MyClassesClass> array;

    // create constructor


    public MyAdapter(Context con, ArrayList<MyClassesClass> array) {
        this.con = con;
        this.array = array;
    }

    @Override
    public int getCount() {
        return array.size();
    }

    @Override
    public Object getItem(int position) {
        return position;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        convertView = LayoutInflater.from(con).inflate(R.layout.rowdesign,parent,false);

        //TextView num = convertView.findViewById(R.id.);
        TextView coursename = convertView.findViewById(R.id.classname);
        TextView assignment = convertView.findViewById((R.id.assignments));
        TextView asstotal = convertView.findViewById(R.id.asstotal);

        // set data into textview...
        coursename.setText(array.get(position).getCoursename());
        assignment.setText((array.get(position).getAssignment()));

        asstotal.setText(array.get(position).getAsstotal());





        return convertView;
    }
}
