package com.example.sajayanegar.controller;

import com.example.sajayanegar.model.CourseRating;
import com.example.sajayanegar.model.Student;
import com.example.sajayanegar.repository.CourseRatingRepository;
import com.example.sajayanegar.repository.CourseRepository;
import com.example.sajayanegar.service.CourseService;
import com.example.sajayanegar.service.StudentService;
import lombok.val;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/student")
public class StudentController {

    @Autowired
    StudentService studentService;

    @Autowired
    CourseService courseService;


    @Autowired
    CourseRepository courseRepository;
    @Autowired
    CourseRatingRepository courseRatingRepository;

    @GetMapping("/{id}")
    public ResponseEntity<Student> getStudentById(@PathVariable String id) {
        try {
            val result = studentService.findByStudentCode(id);
            return new ResponseEntity<>(result, HttpStatus.FOUND);

        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping
    public ResponseEntity<Student> createStudent(@RequestBody Student student) {
        try {
            return new ResponseEntity<>(studentService.create(student), HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.CONFLICT);
        }
    }

    @PatchMapping("/registerStudent")
    public ResponseEntity<Student> registerStudentToCourse(@RequestParam String studentCode, @RequestParam String courseCode) {
        try {
            return new ResponseEntity<>(studentService.registerStudentToCourse(studentCode, courseCode), HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.CONFLICT);
        }

    }

    @PatchMapping("/addscore")
    public ResponseEntity<Student> addRating(@RequestBody CourseRating courseRating, @RequestParam String studentCode) {
        try {
            return new ResponseEntity<>(studentService.addRating(courseRating, studentCode), HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.CONFLICT);
        }
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteStudent(@PathVariable String id) {
        try {
            studentService.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.CONFLICT);
        }
    }

}
