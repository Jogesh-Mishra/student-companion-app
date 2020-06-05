package com.example.studentcompanionapp;

public class Documents {

    private String name;
    private String mImageUrl;

    public Documents(){

    }

    public Documents(String name, String mImageUrl) {
        if(name.trim().equals("")){
            name = "No Name";
        }
        this.name = name;
        this.mImageUrl = mImageUrl;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getmImageUrl() {
        return mImageUrl;
    }

    public void setmImageUrl(String mImageUrl) {
        this.mImageUrl = mImageUrl;
    }
}
