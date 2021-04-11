package com.iiitb.feign.payloads;

import java.io.Serializable;

public class tutorresponse {
    private String response;

    public tutorresponse(String response) {
        this.response = response;
    }

    public String getResponse() {
        return response;
    }

    public void setResponse(String response) {
        this.response = response;
    }
}
