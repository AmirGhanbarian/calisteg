package com.example.sajayanegar.controller;

import com.example.sajayanegar.model.CourseRating;
import com.example.sajayanegar.model.Student;
import com.example.sajayanegar.repository.CourseRatingRepository;
import com.example.sajayanegar.service.CourseRatingService;
import com.example.sajayanegar.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/rating")
public class RatingController {

    @Autowired
    private CourseRatingService courseRatingService;

    @GetMapping("/{id}")
    public ResponseEntity<CourseRating> getById(@PathVariable Long id) throws Exception {
        return new ResponseEntity<>(courseRatingService.getById(id), HttpStatus.FOUND);
    }
}
