package com.iiitb.tutorhunt.Models;

import javax.persistence.*;

@Entity
@Table(name="Course")
public class Course {

    @Id
    @Column(name="courseid")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer courseid;

   @Column(name="coursename",length = 100, nullable = false)
   private String coursename;

    @Column(name="Objective",length = 100, nullable = false)
    private String objective;


    public Course(){

    }

    public Course(String coursename, String objective) {
        this.coursename = coursename;
        this.objective = objective;
    }

    public Integer getCourseid() {
        return courseid;
    }

    public void setCourseid(Integer courseid) {
        this.courseid = courseid;
    }

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
}
