package com.iiitb.feign.payloads;

public class bookslotrequest {

    private int id;
    private int tutor_id;
    private String date;
    private String time;

    public bookslotrequest(int id, int tutor_id, String date, String time) {
        this.id = id;
        this.tutor_id = tutor_id;
        this.date = date;
        this.time = time;
    }

    public int getStudent_id() {
        return id;
    }

    public void setStudent_id(int id) {
        this.id = id;
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
