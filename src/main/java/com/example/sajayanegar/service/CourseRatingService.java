package com.example.sajayanegar.service;

import com.example.sajayanegar.model.CourseRating;
import com.example.sajayanegar.model.Student;

public interface CourseRatingService {
    CourseRating addRating(Long studentId,
                             Long courseId,
                             int rating) throws Exception;

    CourseRating getById(Long id)throws Exception;
}
