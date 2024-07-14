package com.example.sajayanegar.controller;

import com.example.sajayanegar.model.Course;
import com.example.sajayanegar.model.Student;
import com.example.sajayanegar.repository.CourseRepository;
import com.example.sajayanegar.service.CourseService;
import lombok.val;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/courses")
public class CourseController {

    @Autowired
    CourseService courseService;


    @Autowired
    CourseRepository courseRepository;

    @PostMapping("/register-student")
    public Course registerStudentById(@RequestParam Long studentId, @RequestParam Long courseId) throws Exception {
        return courseService.registerByStudentId(studentId, courseId);
    }

    @PostMapping("/")
    public Course createCourse(@RequestBody Course simpleCourseDto) throws Exception {
        return courseRepository.save(simpleCourseDto);
    }

    @GetMapping("/{id}")
    public Course getCourseById(@PathVariable String id) throws Exception {
        val course = courseRepository.findById(id);
        return course;
    }
}
