package com.example.sajayanegar.model;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.Objects;

@Embeddable
@Getter
@Setter
class CourseRatingKey implements Serializable {

    @Column(name = "studentId")
    Long studentId;

    @Column(name = "courseId")
    Long courseId;

    // standard constructors, getters, and setters
    // hashcode and equals implementation

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CourseRatingKey that = (CourseRatingKey) o;

        if (!Objects.equals(studentId, that.studentId)) return false;
        return Objects.equals(courseId, that.courseId);
    }

    @Override
    public int hashCode() {
        int result = studentId != null ? studentId.hashCode() : 0;
        result = 31 * result + (courseId != null ? courseId.hashCode() : 0);
        return result;
    }
}