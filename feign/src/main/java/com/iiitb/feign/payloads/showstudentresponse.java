package com.iiitb.feign.payloads;

import com.iiitb.feign.DTO.UserBooking;

import java.util.List;

public class showstudentresponse {

    private List<UserBooking> response;

    public List<UserBooking> getResponse() {
        return response;
    }

    public void setResponse(List<UserBooking> response) {
        this.response = response;
    }

    public showstudentresponse(List<UserBooking> response) {
        this.response = response;
    }
}


