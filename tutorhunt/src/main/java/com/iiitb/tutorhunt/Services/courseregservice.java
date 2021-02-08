package com.iiitb.tutorhunt.Services;


import com.iiitb.tutorhunt.Models.Course;
import com.iiitb.tutorhunt.Repository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class courseregservice {

    @Autowired
    private CourseRepository courserepo;

    public boolean registerCourse(Course courses){
        try{
            courserepo.save(courses);
            return true;
        }
        catch (Exception e){
            System.out.println(e.getLocalizedMessage());
            return false;
        }


    }
}
