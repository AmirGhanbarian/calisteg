package com.example.sajayanegar.controller;

import com.example.sajayanegar.model.Student;
import com.example.sajayanegar.repository.StudentRepository;
import com.example.sajayanegar.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController("/student")
public class StudentController {

    @Autowired
    StudentService studentService;

    @GetMapping("/{id}")
    public Student getStudentById(@PathVariable Long id) {
        return studentService.getById(id);
    }

    @PostMapping
    public Student createStudent(@RequestBody Student student) {
        return studentService.createStudent(student);
    }
}
