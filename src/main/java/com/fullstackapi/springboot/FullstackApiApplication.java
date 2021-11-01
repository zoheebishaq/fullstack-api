package com.fullstackapi.springboot;

import com.fullstackapi.springboot.model.Student;
import com.fullstackapi.springboot.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class FullstackApiApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(FullstackApiApplication.class, args);
    }

    @Autowired
    private StudentRepository studentRepository;

    @Override
    public void run(String... args) throws Exception {
//        Student student = new Student();
//        student.setFirstName("Zoheeb");
//        student.setLastName("Ishaque");
//        student.setEmail("zoheeb@gmail.com");
//        studentRepository.save(student);
//
//        Student student1 = new Student();
//        student1.setFirstName("Pierre");
//        student1.setLastName("Gris");
//        student1.setEmail("pierre@gmail.com");
//        studentRepository.save(student1);
    }
}
