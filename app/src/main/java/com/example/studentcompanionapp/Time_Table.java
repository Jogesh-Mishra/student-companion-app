package com.example.studentcompanionapp;

import java.sql.Time;

public class Time_Table {
    private String Imageurl;

    public Time_Table(){

    }

    public Time_Table(String imageurl) {
        Imageurl = imageurl;
    }

    public String getImageurl() {
        return Imageurl;
    }

    public void setImageurl(String imageurl) {
        Imageurl = imageurl;
    }
}
