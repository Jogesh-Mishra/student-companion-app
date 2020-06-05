package com.example.studentcompanionapp;

public class StudentBiodata {
    private String id;
    private String name;
    private String regd;
    private String sem;
    private String branch;

    public StudentBiodata(){

    }

    public StudentBiodata(String id, String name, String regd, String sem, String branch) {
        this.id = id;
        this.name = name;
        this.regd = regd;
        this.sem = sem;
        this.branch = branch;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRegd() {
        return regd;
    }

    public void setRegd(String regd) {
        this.regd = regd;
    }

    public String getSem() {
        return sem;
    }

    public void setSem(String sem) {
        this.sem = sem;
    }

    public String getBranch() {
        return branch;
    }

    public void setBranch(String branch) {
        this.branch = branch;
    }
}
