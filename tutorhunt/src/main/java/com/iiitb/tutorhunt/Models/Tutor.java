package com.iiitb.tutorhunt.Models;


import javax.persistence.*;

@Entity
@Table(name="Tutor")
public class Tutor {



    @Id
    @Column(name="id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="tutorid",nullable=false)
    private Long tutorid;

    @Column(name="course_id",nullable=false)
    private Integer course_id;

    @Column(name="Age",nullable=false)
    private Integer age;

    @Column(name="Gender",nullable=false)
    private String gender;

    @Column(name="Qualification",nullable = false)
    private String qualification;

    @Column(name = "Fee",nullable= false)
    private Double fee;

    @Column(name="Name",nullable = false)
    private String name;

    public Tutor() {

    }

    public Tutor(Long tutorid,String name,Integer course_id, Integer age, String gender, String qualification, Double fee) {
        this.tutorid=tutorid;
        this.name=name;
        this.course_id = course_id;
        this.age = age;
        this.gender = gender;
        this.qualification = qualification;
        this.fee = fee;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getCourse_id() {
        return course_id;
    }

    public void setCourse_id(Integer course_id) {
        this.course_id = course_id;
    }

    public Integer getAge() {
        return age;
    }

    public Long getTutor_id() { return tutorid; }

    public void setTutorid(Long tutorid) { this.tutorid = tutorid; }

    public Double getFee() { return fee; }

    public void setFee(Double fee) { this.fee = fee; }

    public String getName() { return name; }

    public void setName(String name) { this.name = name; }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getQualification() {
        return qualification;
    }

    public void setQualification(String qualification) {
        this.qualification = qualification;
    }




}
