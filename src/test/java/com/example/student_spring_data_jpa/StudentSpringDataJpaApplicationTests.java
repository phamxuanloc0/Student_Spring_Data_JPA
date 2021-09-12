package com.example.student_spring_data_jpa;

import com.example.student_spring_data_jpa.entity.Student;
import com.example.student_spring_data_jpa.repository.StudentRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
 class StudentSpringDataJpaApplicationTests {

    @Autowired
    private StudentRepository studentRepository;
//    @Test
//    void contextLoads() {
//    }

        @Test
    public void saveStudentRepo(){
        Student student = Student.builder()
                .firstName("Pham xuan")
                .lastName("loc")
                .mail("loctech@gmail.com")
                .build();
        studentRepository.save(student);
    }

}
