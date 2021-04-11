package com.iiitb.tutorhunt.Services;


import com.iiitb.tutorhunt.Models.Course;
import com.iiitb.tutorhunt.Repository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class courseregservice {

    @Autowired
    private CourseRepository courserepo;

    public boolean registerCourse(Course courses) {
        try {
            courserepo.save(courses);
            return true;
        } catch (Exception e) {
            System.out.println(e.getLocalizedMessage());
            return false;
        }


    }

    public List<Course> courseList() {
        return courserepo.findAll();


    }

    public List<String> getAllCourses() {
        List<Course> courses = courseList();
        List<String> result = new ArrayList<>();
        for (Course c : courses) {
            if (c.getCoursename() != null) {
                result.add(c.getCoursename());
            }
        }

        return result;

    }
}
