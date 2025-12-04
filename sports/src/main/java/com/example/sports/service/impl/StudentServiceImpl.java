package com.example.sports.service.impl;

import com.example.sports.model.Student;
import com.example.sports.repository.StudentRepository;
import com.example.sports.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentRepository studentRepository;

    // This method is called from AuthController during registration
    @Override
    public Student registerStudent(Student student) {
        return studentRepository.save(student); // save to DB
    }

    // This method is called from AuthController during login
    @Override
    public Student loginStudent(String regdNumber, String password) {
        return studentRepository.findByRegdNumberAndPassword(regdNumber, password)
                .orElse(null); // return student if match found, else null
    }

    @Override
    public List<Student> getAllStudents() {
        return studentRepository.findAll(); // fetch all records
    }

    // Extra methods for AuthController

    public boolean existsByRegdNumber(String regdNumber) {
        return studentRepository.existsById(regdNumber);
    }

    public Student saveStudent(Student student) {
        return studentRepository.save(student);
    }

    public Student findByRegdNumber(String regdNumber) {
        Optional<Student> student = studentRepository.findByRegdNumber(regdNumber);
        return student.orElse(null);
    }
}
