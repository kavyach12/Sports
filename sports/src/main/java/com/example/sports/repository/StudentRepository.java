package com.example.sports.repository;

import com.example.sports.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface StudentRepository extends JpaRepository<Student, String> {
    // Find student by registration number (primary key)
    Optional<Student> findByRegdNumber(String regdNumber);

    // For login (match regdNumber and password)
    Optional<Student> findByRegdNumberAndPassword(String regdNumber, String password);
}
