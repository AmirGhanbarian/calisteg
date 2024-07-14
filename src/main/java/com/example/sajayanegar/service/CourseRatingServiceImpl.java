package com.example.sajayanegar.service;

import com.example.sajayanegar.model.CourseRating;
import com.example.sajayanegar.model.Student;
import com.example.sajayanegar.repository.CourseRatingRepository;
import lombok.val;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CourseRatingServiceImpl implements CourseRatingService {

    @Autowired
    private StudentService studentService;
    @Autowired
    private CourseService courseService;
    @Autowired
    private CourseRatingRepository courseRatingRepository;


    public CourseRating addRating(Long studentId,
                             Long courseId,
                             int rating) throws Exception {
        return null;
    }

    @Override
    public CourseRating getById(Long id) throws Exception {
       return this.findById(id);
    }



    private CourseRating findById(Long id) throws Exception {
        val result = courseRatingRepository.findById(id);
        if (result.isPresent()) {
            return result.get();
        } else {
            throw new Exception("student not found");
        }
    }
}
