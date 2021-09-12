package com.example.student_spring_data_jpa;

import com.example.student_spring_data_jpa.entity.Student;
import com.example.student_spring_data_jpa.repository.StudentRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class StudentSpringDataJpaApplication {

    public static void main(String[] args) {
        SpringApplication.run(StudentSpringDataJpaApplication.class, args);
    }


    private void insertStudent(StudentRepository studentRepository){
        Student student = Student.builder()
                .firstName("Xuan")
                .lastName("Loc")
                .mail("locxuan@gmail.com")
                .build();
        studentRepository.save(student);
    }
    @Bean
    public CommandLineRunner run(StudentRepository studentRepository){
        return (args -> {
            insertStudent(studentRepository);
        });
    }
}
