package com.example.sajayanegar.repository;

import com.example.sajayanegar.model.Course;
import com.example.sajayanegar.model.Student;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface StudentRepository extends MongoRepository<Student,Long> {


    Optional<Student> findById(String id);

    Optional<Student> findByStudentCode(String studentCode);

    void deleteById(String id);

}
