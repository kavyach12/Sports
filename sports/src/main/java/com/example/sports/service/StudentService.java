package com.example.sports.service;

import com.example.sports.model.Student;
import java.util.List;

public interface StudentService {
    Student registerStudent(Student student);
    Student loginStudent(String regdNumber, String password);
    List<Student> getAllStudents();
}
