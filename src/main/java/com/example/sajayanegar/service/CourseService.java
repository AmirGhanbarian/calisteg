package com.example.sajayanegar.service;


import com.example.sajayanegar.model.Course;
import com.example.sajayanegar.model.Student;

import java.util.Optional;

public interface CourseService {
    Course getById(Long id) throws Exception;
    Course registerByStudentId(Long studentId, Long courseId) throws Exception;
    Course updateCourse(Course course) throws Exception;

    Course findByCourseCode(String courseCode) throws Exception;

}
