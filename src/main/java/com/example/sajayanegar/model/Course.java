package com.example.sajayanegar.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.Set;


@Getter
@Setter
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Course {

    @Id
    private Long id;

    private String name;

    @OneToMany(mappedBy = "course")
    Set<CourseRating> ratings;
    @ManyToMany(mappedBy = "courses",fetch = FetchType.LAZY)
    private Set<Student> students;

}
