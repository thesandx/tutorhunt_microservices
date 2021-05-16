package com.iiitb.tutorhunt.Controller;

import com.iiitb.tutorhunt.Models.Course;
import com.iiitb.tutorhunt.Services.SubjectUpdateService;
import com.iiitb.tutorhunt.Services.courseregservice;
import com.iiitb.tutorhunt.Services.loginservice;
import com.iiitb.tutorhunt.payloads.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;


@RestController
@CrossOrigin
@RequestMapping(value = "/Course",method= RequestMethod.POST)
public class CourseController {

    @Autowired
    private courseregservice crs;

    @Autowired
    private SubjectUpdateService sus;



    @PostMapping("/courses")
    public ResponseEntity<String> CourseRegister(@RequestBody courserequest creq){

        String cname=creq.getCoursename();
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


    @GetMapping("/getAllCourses")
    public List<String> getAllCourses(){

        return crs.getAllCourses();

    }
//    @GetMapping("/tutorcourse")
//    public List<String> tutorCourses(@RequestBody Long tutorid){
//        List<String> result =sus.getcourseName(tutorid);
//        return result;
//
//    }

    @PutMapping("/updatesubject")
    public ResponseEntity<?> UpdateTutor(@RequestBody updaterequest ureq) {


          //  String cname = treq.getCourse_name();
            //System.out.println(cname);
            Long tutorid= ureq.getTutorid();
            String gender = ureq.getGender();
            // System.out.println(gender);
            String qualification = ureq.getQualification();
            //System.out.println(qualification);
            Integer age = ureq.getAge();
            // System.out.println(age);
            Double fee = ureq.getFee();
            // System.out.println(fee);
            String name = ureq.getName();
            //  System.out.print("Hello");
           // String objective = treq.getObjective();
            //System.out.println(objective);
            boolean result = sus.UpdateTutor(age,gender,qualification,fee,name,tutorid);
            if(result){
                return ResponseEntity.ok(new tutorresponse("Updated"));
            }
            else{
                return ResponseEntity.ok(new tutorresponse("Not_Updated"));
            }

    }
    @PostMapping("/getCourseObjective")
    public ResponseEntity<BookingResponse> getCourseObj(@RequestBody Bookingrequest book){
        String name = book.getName();
        Integer cid=book.getCourseid();
        return ResponseEntity.ok(new BookingResponse(crs.getCourseObj(name,cid)));
    }

}
