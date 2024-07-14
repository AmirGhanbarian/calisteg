package com.example.sajayanegar.repository;

import com.example.sajayanegar.model.Course;
import com.example.sajayanegar.model.Student;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface CourseRepository  extends MongoRepository<Course,Long> {

    Course findById(String id);
    Optional<Course> findByCourseCode(String id);
}
