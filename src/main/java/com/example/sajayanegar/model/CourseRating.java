package com.example.sajayanegar.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
class CourseRating {

    @EmbeddedId
    CourseRatingKey id;

    @ManyToOne
    //@MapsId("studentId")
    @JoinColumn(name = "studentId_rating")
    private Student student;

    @ManyToOne
    //@MapsId("courseId")
    @JoinColumn(name = "courseId_rating")
    private Course course;

    private int rating;

}