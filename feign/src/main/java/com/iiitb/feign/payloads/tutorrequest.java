package com.iiitb.feign.payloads;

import javax.validation.constraints.NotBlank;

public class tutorrequest {

    @NotBlank
    private String name;

    @NotBlank
    private String course_name;

    @NotBlank
    private Integer age;

    @NotBlank
    private String gender;

    @NotBlank
    private String qualification;

    @NotBlank
    private Double fee;

    @NotBlank
    private String objective;

    @NotBlank
    private Long id;



    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() { return name; }

    public void setName(String name) { this.name = name; }

    public String getCourse_name() {
        return course_name;
    }

    public void setCourse_name(String course_name) {
        this.course_name = course_name;
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

    public String getObjective() { return objective; }

    public void setObjective(String objective) { this.objective = objective; }


    public tutorrequest(@NotBlank String name,@NotBlank String course_name, @NotBlank Integer age, @NotBlank String gender, @NotBlank String qualification, @NotBlank Double fee, @NotBlank String objective,@NotBlank Long id) {
        this.name=name;
        this.course_name = course_name;
        this.age = age;
        this.gender = gender;
        this.qualification = qualification;
        this.fee = fee;
        this.objective=objective;
        this.id=id;
    }



}
