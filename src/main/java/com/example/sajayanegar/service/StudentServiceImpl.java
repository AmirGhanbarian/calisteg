package com.example.sajayanegar.service;

import com.example.sajayanegar.model.Course;
import com.example.sajayanegar.model.CourseRating;
import com.example.sajayanegar.model.Student;
import com.example.sajayanegar.repository.CourseRatingRepository;
import com.example.sajayanegar.repository.StudentRepository;
import lombok.val;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private CourseService courseService;
    @Autowired
    private CourseRatingRepository courseRatingRepository;

    public Student getById(Long id) throws Exception {
        return this.findById(id);
    }

    public Student create(Student student) throws Exception {
        return studentRepository.save(student);
    }

    @Override
    public Student update(Student student) throws Exception {
        return studentRepository.save(student);
    }

    private Student findById(Long id) throws Exception {
        val result = studentRepository.findById(id);
        if (result.isPresent()) {
            return result.get();
        } else {
            throw new Exception("student not found");
        }
    }

    public Student findById(String id) throws Exception {
        val result = studentRepository.findById(id);
        if (result.isPresent()) {
            return result.get();
        } else {
            throw new Exception("student not found");
        }
    }

    public Student registerStudentToCourse(String studentCode, String courseCode) throws Exception {
        val student = this.findByStudentCode(studentCode);
        val course = courseService.findByCourseCode(courseCode);
        val studentCourses = fetchAndAddCourseToStudent(student, course);
        student.setCourses(studentCourses);
        deleteTheOldStudentDocument(student.getId());
        return saveTheNewStudent(student);
    }

    @Override
    public Student addRating(CourseRating courseRating, String studentCode) throws Exception {
        val result = studentRepository.findByStudentCode(studentCode);
        if (result.isPresent()) {
            val student = result.get();
            courseRatingRepository.save(courseRating);
            deleteTheOldStudentDocument(student.getId());
            student.setId(null);
            val studentRatings = student.getRatings() != null ? student.getRatings() : new HashSet<CourseRating>();
            studentRatings.add(courseRating);
            student.setRatings(studentRatings);
            return studentRepository.save(student);
        } else {
            throw new Exception();
        }
    }

    @Override
    public void deleteById(String id) {
        studentRepository.deleteById(Long.decode(id));

    }

    private Set<Course> fetchAndAddCourseToStudent(Student student, Course course) {
        Set<Course> studentCourses = student.getCourses() == null ? new HashSet<>() : student.getCourses();
        studentCourses.add(course);
        return studentCourses;
    }

    @Override
    public Student findByStudentCode(String studentCode) throws Exception {
        val result = studentRepository.findByStudentCode(studentCode);
        if (result.isPresent()) {
            return result.get();
        } else {
            throw new Exception();
        }
    }

    private void deleteTheOldStudentDocument(String id) {
        studentRepository.deleteById(id);

    }

    private Student saveTheNewStudent(Student student) {
        student.setId(null);
        return studentRepository.insert(student);
    }

}
