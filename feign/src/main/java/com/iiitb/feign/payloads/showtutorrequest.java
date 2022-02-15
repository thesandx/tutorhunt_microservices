package com.iiitb.feign.payloads;

public class showtutorrequest {
    public int getStudent_id() {
        return student_id;
    }

    public void setStudent_id(int student_id) {
        this.student_id = student_id;
    }

    public showtutorrequest(int student_id) {
        this.student_id = student_id;
    }

    private int student_id;

    public showtutorrequest(){

    }
}
