package com.iiitb.tutorhunt.payloads;

import javax.validation.constraints.NotBlank;

public class courserequest {

    @NotBlank
    private String coursename;

    @NotBlank
    private String objective;


    public String getCoursename() {
        return coursename;
    }

    public void setCoursename(String coursename) {
        this.coursename = coursename;
    }

    public String getObjective() {
        return objective;
    }

    public void setObjective(String objective) {
        this.objective = objective;
    }

    public courserequest(@NotBlank String coursename, @NotBlank String objective) {
        this.coursename = coursename;
        this.objective = objective;
    }
}
