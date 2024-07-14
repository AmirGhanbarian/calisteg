package com.example.sajayanegar.service;

import com.example.sajayanegar.model.CourseRating;
import com.example.sajayanegar.model.Student;

public interface StudentService {
    Student getById(Long id) throws Exception;
    Student create(Student student) throws Exception;
    Student update(Student student) throws Exception;
    Student findByStudentCode(String studentCode) throws Exception;
    Student registerStudentToCourse(String studentCode,String courseCode) throws Exception;
    Student addRating(CourseRating courseRating,  String studentCode) throws Exception;
    void deleteById(String id)throws Exception;
    Student findById(String id) throws Exception;
}
