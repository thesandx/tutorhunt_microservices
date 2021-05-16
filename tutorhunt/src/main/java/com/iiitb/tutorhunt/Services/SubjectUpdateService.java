package com.iiitb.tutorhunt.Services;

import com.iiitb.tutorhunt.Models.Course;
import com.iiitb.tutorhunt.Models.Tutor;
import com.iiitb.tutorhunt.Repository.CourseRepository;
import com.iiitb.tutorhunt.Repository.TutorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class SubjectUpdateService {

    @Autowired
    private TutorRepository trepo;
    @Autowired
    private CourseRepository courserepo;

    public List<String> getcourseName(Long tutorid){

        Tutor tutors=trepo.findTutorByTutorid(tutorid);
        Integer id =tutors.getCourse_id();
        List<String> res=findCourseByTutor(id);
        return res;
    }

    public List<Course> courseList(){
        return courserepo.findAll();

    }

    public List<String> findCourseByTutor(int courseId){

        List<Course> courses = courseList();
        List<String> result = new ArrayList<>();

        for(Course cr: courses){

            if(cr.getCourseid()==courseId){
                result.add(cr.getCoursename());
            }

        }
        return result;
    }

    @Transactional
    public boolean UpdateTutor(int age,String gender,String qualification,double fee,String name,Long tutorid){
        int result = trepo.fetchUpdatedTutor(age, gender, qualification, fee, name, tutorid);
        if(result >= 1){
            return true;
        }
        else{
            return false;
        }
    }


}
