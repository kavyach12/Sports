package com.example.sports.controller;

import com.example.sports.model.Student;
import com.example.sports.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/students")
public class StudentController {

    @Autowired
    private StudentRepository studentRepository;

    // Get all registered students
    @GetMapping("/all")
    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    // Optionally, get a student by registration number
    @GetMapping("/{regdNumber}")
    public Student getStudentByRegdNumber(@PathVariable String regdNumber) {
        return studentRepository.findById(regdNumber)
                .orElseThrow(() -> new RuntimeException("Student not found: " + regdNumber));
    }
}
