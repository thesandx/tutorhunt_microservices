package com.iiitb.tutorhunt.Controller;

import com.iiitb.tutorhunt.Models.Course;
import com.iiitb.tutorhunt.Models.Tutor;
import com.iiitb.tutorhunt.Services.courseregservice;
import com.iiitb.tutorhunt.Services.tutorRegservice;
import com.iiitb.tutorhunt.payloads.TutorList;
import com.iiitb.tutorhunt.payloads.tutorrequest;
import com.sun.org.apache.bcel.internal.generic.LCONST;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping(value = "/Tutor" , method = RequestMethod.POST)
public class TutorRegController {

    @Autowired
    private tutorRegservice treg;

    @Autowired
    private courseregservice crs;

    @PostMapping("/application")
    public ResponseEntity<String> TutorRegistration(@RequestBody tutorrequest treq){

        String cname=treq.getCourse_name();
        //System.out.println(cname);
        String gender= treq.getGender();
       // System.out.println(gender);
        String qualification=treq.getQualification();
        //System.out.println(qualification);
        Integer age=treq.getAge();
       // System.out.println(age);
        Double cost=treq.getCost();
       // System.out.println(cost);
        String name=treq.getName();

      //  System.out.print("Hello");
        String objective= treq.getObjective();
        System.out.println(objective);
        Course courses=new Course(cname,objective);
        boolean result=crs.registerCourse(courses);
        if(result){
            Integer cid=treg.getcourseId(cname);
            //  System.out.println(cid);
            // Course courses=new Course(cname,objective);
            Tutor tutors=new Tutor(name,cid,age,gender,qualification,cost);
            result=treg.TutorRegistration(tutors);
            if(result){
                return ResponseEntity.ok("Course_Registered")   ;
            }
            else{
                return ResponseEntity.ok("Course_not_registered");
            }
        }
        else{
            return ResponseEntity.ok("Course_not_registered");
        }


    }



    @PostMapping("/tutorlist")
    public ResponseEntity<List<Tutor>> TutorList(@RequestBody TutorList tutor){

        //find id of course
        int subjectId=0;

        List<Course> courseList = crs.courseList();

        for(Course c : courseList){
            if(c.getCoursename().equalsIgnoreCase(tutor.getCourse())){
                subjectId = c.getCourseid();
                break;
            }
        }

        System.out.println("Subject is "+tutor.getCourse());
        System.out.print("Course id is "+subjectId);

        return ResponseEntity.ok(treg.findTutorByCourse(subjectId));


    }


}
