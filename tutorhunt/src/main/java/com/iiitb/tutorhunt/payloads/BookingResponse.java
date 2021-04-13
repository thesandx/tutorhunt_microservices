package com.iiitb.tutorhunt.payloads;

import java.util.List;

public class BookingResponse {
    private List<String> response;

    public List<String> getResponse() {
        return response;
    }

    public void setResponse(List<String> response) {
        this.response = response;
    }

    public BookingResponse(List<String> response) {
        this.response = response;
    }
}



