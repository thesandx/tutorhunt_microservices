package com.iiitb.tutorhunt.Repository;

import com.iiitb.tutorhunt.Models.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CourseRepository extends JpaRepository<Course,Integer> {

    Course findCourseByCoursename(String course_name);   //Dont ever use underscored Field names
}
