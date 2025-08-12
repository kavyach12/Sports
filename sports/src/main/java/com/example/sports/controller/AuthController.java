package com.example.sports.controller;

import com.example.sports.model.Student;
import com.example.sports.service.impl.StudentServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private StudentServiceImpl studentService;

    // Register a student
    @PostMapping("/register")
    public ResponseEntity<String> register(@RequestBody Student student) {
        // Check if regdNumber already exists
        if (studentService.existsByRegdNumber(student.getRegdNumber())) {
            return ResponseEntity.badRequest().body("Registration number already exists!");
        }
        studentService.saveStudent(student);
        return ResponseEntity.ok("Student registered successfully!");
    }

    // Login
    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody Student student) {
        Student existingStudent = studentService.findByRegdNumber(student.getRegdNumber());

        if (existingStudent != null && existingStudent.getPassword().equals(student.getPassword())) {
            return ResponseEntity.ok("Login successful!");
        }
        return ResponseEntity.status(401).body("Invalid registration number or password");
    }
}
