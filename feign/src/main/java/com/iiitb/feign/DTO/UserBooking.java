package com.iiitb.feign.DTO;

public class UserBooking {

    private String name;
    //private String tutorid;
    private String date;
    private String time;

    public UserBooking(String name, String date, String time) {
        this.name = name;
        //this.tutor = empName;
        this.date = date;
        this.time = time;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

//    //getters and setters
//
//    @Override
//    public String toString() {
//        return "DeptEmpDto [empDept=" + empDept + ", empName=" + empName + ", empEmail=" + empEmail + ", empAddress="
//                + empAddress + "]";
//    }

}
