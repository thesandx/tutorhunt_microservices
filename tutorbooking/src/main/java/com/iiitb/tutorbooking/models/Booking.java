package com.iiitb.tutorbooking.models;


import javax.persistence.*;

@Entity
@Table(name = "Booking")
public class Booking {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "student_id")
    private int student_id;

    @Column(name = "tutor_id")
    private int tutor_id;

    @Column(name = "date")
    private String date;

    @Column(name = "time")
    private String time;


    public Booking() {
    }

    public Booking(int id, int student_id, int tutor_id, String date, String time) {
        this.id = id;
        this.student_id = student_id;
        this.tutor_id = tutor_id;
        this.date = date;
        this.time = time;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getStudent_id() {
        return student_id;
    }

    public void setStudent_id(int student_id) {
        this.student_id = student_id;
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
