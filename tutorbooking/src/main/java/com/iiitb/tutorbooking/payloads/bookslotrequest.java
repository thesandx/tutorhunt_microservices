package com.iiitb.tutorbooking.payloads;

public class bookslotrequest {
    private int student_id;
    private int tutor_id;
    private String date;
    private String time;

    public bookslotrequest(int student_id, int tutor_id, String date, String time) {
        this.student_id = student_id;
        this.tutor_id = tutor_id;
        this.date = date;
        this.time = time;
    }

    public int getStudent_id() {
        return student_id;
    }

    public void setStudent_id(int student_id) {
        this.student_id = student_id;
    }

    public int getTutor_id() {
        return tutor_id;
    }

    public void setTutor_id(int tutor_id) {
        this.tutor_id = tutor_id;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }
}
