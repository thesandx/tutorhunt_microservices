package com.iiitb.tutorhunt.payloads;

import javax.validation.constraints.NotBlank;

public class updaterequest {
    @NotBlank
    private String name;



    @NotBlank
    private Long tutorid;

    @NotBlank
    private Integer age;

    @NotBlank
    private String gender;

    @NotBlank
    private String qualification;

    @NotBlank
    private Double fee;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getTutorid() {
        return tutorid;
    }

    public void setTutorid(Long tutorid) {
        this.tutorid = tutorid;
    }

    public Integer getAge() {
        return age;
    }

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

    public Double getFee() {
        return fee;
    }

    public void setFee(Double fee) {
        this.fee = fee;
    }

    public updaterequest(String name, Long tutorid, Integer age, String gender, String qualification, Double fee) {
        this.name = name;
        this.tutorid = tutorid;
        this.age = age;
        this.gender = gender;
        this.qualification = qualification;
        this.fee = fee;
    }
}
