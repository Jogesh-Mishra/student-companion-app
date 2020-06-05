package com.example.studentcompanionapp;

public class Add_Back {
    private String id;
    private String semester;
    private String subject;
    private String attempt;


    public Add_Back(){

    }

    public Add_Back(String id, String semester, String subject, String attempt) {
        this.id = id;
        this.semester = semester;
        this.subject = subject;
        this.attempt = attempt;
    }

    public String getSemester() {
        return semester;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setSemester(String semester) {
        this.semester = semester;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getAttempt() {
        return attempt;
    }

    public void setAttempt(String attempt) {
        this.attempt = attempt;
    }
}
