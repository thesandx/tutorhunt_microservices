package com.iiitb.tutorhunt.Controller;

import com.iiitb.tutorhunt.Models.Course;
import com.iiitb.tutorhunt.Services.courseregservice;
import com.iiitb.tutorhunt.Services.loginservice;
import com.iiitb.tutorhunt.payloads.courserequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@CrossOrigin
@RequestMapping(value = "/Course",method= RequestMethod.POST)
public class CourseController {

    @Autowired
    private courseregservice crs;

    @PostMapping("/courses")
    public ResponseEntity<String> CourseRegister(@RequestBody courserequest creq){

        String cname=creq.getCoursename();
        System.out.print("Hello baby");
        String objective= creq.getObjective();
        Course courses=new Course(cname,objective);
        boolean result=crs.registerCourse(courses);
        if(result){
            return ResponseEntity.ok("course_registered");
        }
        else{
            return ResponseEntity.ok("course_not_registered");
        }
    }

}
