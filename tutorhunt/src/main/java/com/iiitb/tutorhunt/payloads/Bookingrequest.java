package com.iiitb.tutorhunt.payloads;

import javax.validation.constraints.NotBlank;

public class Bookingrequest {
    @NotBlank
    private String name;

    @NotBlank
    private Integer courseid;

    public void setName(String name) {
        this.name = name;
    }

    public void setCourseid(Integer courseid) {
        this.courseid = courseid;
    }

    public String getName() {
        return name;
    }

    public Integer getCourseid() {
        return courseid;
    }

    public Bookingrequest(@NotBlank String name, @NotBlank Integer courseid) {
        this.name = name;
        this.courseid = courseid;
    }
}

//
//package com.iiitb.tutorhunt.payloads;
//
//        import javax.validation.constraints.NotBlank;
//
//public class courserequest {
//
//    @NotBlank
//    private String coursename;
//
//    @NotBlank
//    private String objective;
//
//
//    public String getCoursename() {
//        return coursename;
//    }
//
//    public void setCoursename(String coursename) {
//        this.coursename = coursename;
//    }
//
//    public String getObjective() {
//        return objective;
//    }
//
//    public void setObjective(String objective) {
//        this.objective = objective;
//    }
//
//    public courserequest(@NotBlank String coursename, @NotBlank String objective) {
//        this.coursename = coursename;
//        this.objective = objective;
//    }
//}

