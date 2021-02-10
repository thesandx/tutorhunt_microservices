package com.iiitb.tutorhunt.payloads;

public class TutorList {
    String Course;

    public TutorList() {
    }

    public TutorList(String course) {
        Course = course;
    }


    public String getCourse() {
        return Course;
    }

    public void setCourse(String course) {
        Course = course;
    }
}
