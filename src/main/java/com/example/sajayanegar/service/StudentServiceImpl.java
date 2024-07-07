package com.example.sajayanegar.service;

import com.example.sajayanegar.model.Student;
import com.example.sajayanegar.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentRepository studentRepository;
    public Student getById(Long id){
     return studentRepository.getReferenceById(id);
    }

    public Student createStudent(Student student){
        return studentRepository.save(student);
    }
}
