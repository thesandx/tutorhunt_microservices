package com.iiitb.tutorbooking.payloads;

import com.iiitb.tutorbooking.DTO.UserBooking;

import java.util.List;

public class showtutorresponse {

    private List<UserBooking> response;

    public List<UserBooking> getResponse() {
        return response;
    }

    public void setResponse(List<UserBooking> response) {
        this.response = response;
    }

    public showtutorresponse(List<UserBooking> response) {
        this.response = response;
    }
}
