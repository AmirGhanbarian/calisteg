package com.example.sajayanegar.service;

import com.example.sajayanegar.model.Course;
import com.example.sajayanegar.repository.CourseRepository;
import lombok.val;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CourseServiceImpl implements CourseService{

    @Autowired
    CourseRepository courseRepository;
    @Autowired
    StudentService studentService;
    @Override
    public Course getById(Long id) throws Exception {
        return this.findById(id);
    }

    @Override
    public Course registerByStudentId(Long studentId, Long courseId) throws Exception {
        val student=studentService.getById(studentId);
        val course=this.getById(courseId);
        //val studentsEnrolled=course.getStudent();
        //studentsEnrolled.add(student);
        //course.setStudent(studentsEnrolled);
        val studentsCourses=student.getCourses();
        studentsCourses.add(course);
        student.setCourses(studentsCourses);
        studentService.update(student);
        return course;
    }

    @Override
    public Course updateCourse(Course course) throws Exception {
            return courseRepository.save(course);
    }

    @Override
    public Course findByCourseCode(String courseCode) throws Exception{
        val result=courseRepository.findByCourseCode(courseCode);
        if(result.isPresent()){
            return result.get();
        }else{
            throw new Exception("course not found");
        }
    }

    private Course findById(Long id) throws Exception {
        val result = courseRepository.findById(id);
        if (result.isPresent()) {
            return result.get();
        } else {
            throw new Exception("course not found");
        }
    }
}
