package com.iiitb.tutorhunt.Services;


import com.iiitb.tutorhunt.Models.Course;
import com.iiitb.tutorhunt.Models.Tutor;
import com.iiitb.tutorhunt.Repository.CourseRepository;
import com.iiitb.tutorhunt.Repository.TutorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.validation.constraints.Null;
import java.util.ArrayList;
import java.util.List;

@Service
public class courseregservice {

    @Autowired
    private CourseRepository courserepo;
    @Autowired
    private TutorRepository tutorrepo;

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

    public List<Course> courseList(){
        return courserepo.findAll();


    }

    public List<String> getAllCourses(){
        List<Course> courses = courseList();
        List<String> result = new ArrayList<>();
        for(Course c : courses){
            if(c.getCoursename()!=null){
                result.add(c.getCoursename());
            }
        }

        return result;

    }

    public List<Tutor> AllTutor(){

        return tutorrepo.findAll();

    }
    public List<String> getCourseObj(String name,Integer cid){

        List<Tutor> tutors = AllTutor();
        List<String> result = new ArrayList<>();
        List<Course> courses = courseList();
        System.out.println("\nhellooooo"+name+cid);

        for(Course c : courses){
            System.out.println("\n matched");
            if(c.getCourseid()==cid){
                System.out.println(c.getCourseid());
                result.add(c.getObjective());
                System.out.println(c.getObjective() );
            }
        }
        System.out.println(result);
        return result;

    }

}


