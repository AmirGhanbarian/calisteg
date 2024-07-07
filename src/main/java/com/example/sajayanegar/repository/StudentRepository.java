package com.example.sajayanegar.repository;

import com.example.sajayanegar.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student,Long> {
}
