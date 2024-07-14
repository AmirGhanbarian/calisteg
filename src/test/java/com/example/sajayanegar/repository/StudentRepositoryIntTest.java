package com.example.sajayanegar.repository;


import com.example.sajayanegar.SajayanegarApplication;
import com.example.sajayanegar.model.Student;
import lombok.val;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
public class StudentRepositoryIntTest {

    @Autowired
    private StudentRepository studentRepository;
    @Test
    void contextLoads() {
    }
    @Test
    public void saveStudentTest() {

        studentRepository.save(Student.builder()
                .firstName("ali")
                .lastName("bahar")
                .studentCode("401111")
                .build());

        val result=studentRepository.findByStudentCode("401111");
        assertThat(result.isPresent()).isTrue();
        assertThat(result.get().getStudentCode()).isEqualTo("401111");

    }
}
