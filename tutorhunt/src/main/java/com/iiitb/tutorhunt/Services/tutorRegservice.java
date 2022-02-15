package com.iiitb.tutorhunt.Services;

import com.iiitb.tutorhunt.Models.Course;
import com.iiitb.tutorhunt.Models.Tutor;
import com.iiitb.tutorhunt.Repository.CourseRepository;
import com.iiitb.tutorhunt.Repository.TutorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.websocket.Session;
import java.util.ArrayList;
import java.util.List;

@Service
public class tutorRegservice {

    @Autowired
    private TutorRepository tutorrepo;

    @Autowired
    private CourseRepository crepo;

    public Integer getcourseId(String cname){
        //System.out.print(cname);
        Course courses=crepo.findCourseByCoursename(cname);
        Integer id =courses.getCourseid();
        return id;
    }

    public boolean TutorRegistration(Tutor tutors){
        try{
            tutorrepo.save(tutors);
            return true;
        }
        catch (Exception e){
            System.out.println(e.getLocalizedMessage());
            return false;
        }
    }

    public List<Tutor> AllTutor(){

        return tutorrepo.findAll();

    }


    public List<Tutor> findTutorByCourse(int courseId){

        List<Tutor> tutors = AllTutor();
        List<Tutor> result = new ArrayList<>();

        for(Tutor t: tutors){

            if(t.getCourse_id()==courseId){
                result.add(t);
            }

        }

        return result;

    }


}
