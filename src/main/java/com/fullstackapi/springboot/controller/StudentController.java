package com.fullstackapi.springboot.controller;

import com.fullstackapi.springboot.exception.ResourceNotFoundException;
import com.fullstackapi.springboot.model.Student;
import com.fullstackapi.springboot.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/v1/students")
public class StudentController {

    @Autowired
    private StudentRepository studentRepository;

    @GetMapping
    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    // build create student rest api
    @PostMapping
    public Student createStudent(@RequestBody Student student) {
        return studentRepository.save(student);
    }

    //build get student by id rest api
    @GetMapping("{id}")
    public ResponseEntity<Student> getStudentById(@PathVariable long id) {
        Student student = studentRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Student not exist with id" + id));
        return ResponseEntity.ok(student);
    }

    //  build update student rest api
    @PutMapping("{id}")
    public ResponseEntity<Student> updateStudent(@PathVariable long id, @RequestBody Student studentDetails) {
        Student updateStudent = studentRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Student not exist with id" + id));

        updateStudent.setFirstName(studentDetails.getFirstName());
        updateStudent.setLastName(studentDetails.getLastName());
        updateStudent.setEmail(studentDetails.getEmail());

        studentRepository.save(updateStudent);
        return ResponseEntity.ok(updateStudent);
    }

    //build delete student rest api
    @DeleteMapping("{id}")
    public ResponseEntity<HttpStatus> deleteStudent(@PathVariable long id) {

        Student student = studentRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Student not exist with id" + id));

        studentRepository.delete(student);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);

    }
}
