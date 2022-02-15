package com.iiitb.tutorbooking.payloads;

public class showstudentrequest {
    private int tutor_id;

    public int getTutor_id() {
        return tutor_id;
    }

    public void setTutor_id(int tutor_id) {
        this.tutor_id = tutor_id;
    }

    public showstudentrequest(int tutor_id) {
        this.tutor_id = tutor_id;
    }
    public showstudentrequest(){

    }
}
