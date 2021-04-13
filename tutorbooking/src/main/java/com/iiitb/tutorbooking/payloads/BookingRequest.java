package com.iiitb.tutorbooking.payloads;

public class BookingRequest {

    private int tutor_id;
    private String date;

    public BookingRequest() {
    }

    public BookingRequest(int tutor_id, String date) {
        this.tutor_id = tutor_id;
        this.date = date;
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
}
