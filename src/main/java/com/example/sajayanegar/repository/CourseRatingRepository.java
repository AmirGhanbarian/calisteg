package com.example.sajayanegar.repository;

import com.example.sajayanegar.model.Course;
import com.example.sajayanegar.model.CourseRating;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface CourseRatingRepository extends MongoRepository<CourseRating,Long> {
    CourseRating findById(String id);

}
