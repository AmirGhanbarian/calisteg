package com.example.sajayanegar.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.annotation.Nullable;
import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;

import java.util.HashSet;
import java.util.List;
import java.util.Set;


@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Student {

    @Id
    @JsonIgnore
    private String id;

    @Indexed(unique = true)
    private String studentCode;
    private String firstName;
    private String lastName;
    private Set<CourseRating> ratings;
    private Set<Course> courses;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Student student = (Student) o;

        return studentCode.equals(student.studentCode);
    }

    @Override
    public int hashCode() {
        return studentCode.hashCode();
    }

    @Override
    public String toString() {
        return "Student{" +
                "id='" + id + '\'' +
                ", studentCode='" + studentCode + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", ratings=" + ratings +
                ", courses=" + courses +
                '}';
    }
}