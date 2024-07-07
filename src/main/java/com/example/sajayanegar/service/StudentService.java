package com.example.sajayanegar.service;

import com.example.sajayanegar.model.Student;

public interface StudentService {
    Student getById(Long id);
    Student createStudent(Student student);
}
