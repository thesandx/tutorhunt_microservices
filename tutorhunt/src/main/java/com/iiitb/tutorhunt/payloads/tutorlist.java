package com.iiitb.tutorhunt.payloads;

public class tutorlist {
    String Course;

    public tutorlist() {
    }

    public tutorlist(String course) {
        Course = course;
    }


    public String getCourse() {
        return Course;
    }

    public void setCourse(String course) {
        Course = course;
    }
}
