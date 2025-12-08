//package com.example.sports.controller;
//
//import com.example.sports.model.Admin;
//import com.example.sports.model.Student;
//import com.example.sports.service.impl.StudentServiceImpl;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//
//@RestController
//@RequestMapping("/auth")
//public class AuthController {
//
//    @Autowired
//    private StudentServiceImpl studentService;
//
//    // Register a student
//    @PostMapping("/register")
//    public ResponseEntity<String> register(@RequestBody Student student) {
//        // Check if regdNumber already exists
//        if (studentService.existsByRegdNumber(student.getRegdNumber())) {
//            return ResponseEntity.badRequest().body("Registration number already exists!");
//        }
//        studentService.saveStudent(student);
//        return ResponseEntity.ok("Student registered successfully!");
//    }
//
//    // Login
//    @PostMapping("/login")
//    public ResponseEntity<String> login(@RequestBody Student student) {
//        Student existingStudent = studentService.findByRegdNumber(student.getRegdNumber());
//
//        if (existingStudent != null && existingStudent.getPassword().equals(student.getPassword())) {
//            return ResponseEntity.ok("Login successful!");
//        }
//        return ResponseEntity.status(401).body("Invalid registration number or password");
//    }
//
//    // Admin
//
//    @PostMapping("/admin-login")
//    public ResponseEntity<String> adminLogin(@RequestBody Admin admin) {
//    String adminEmail = "admin@example.com";
//    String adminUsername = "admin";
//    String adminPassword = "admin123";
//
//    if(admin.getEmail().equals(adminEmail) &&
//       admin.getUsername().equals(adminUsername) &&
//       admin.getPassword().equals(adminPassword)) {
//        return ResponseEntity.ok("Admin login successful");
//    }
//
//    return ResponseEntity.status(401).body("Invalid admin credentials");
//}
//
//}

package com.example.sports.controller;

import com.example.sports.model.Admin;
import com.example.sports.model.Student;
import com.example.sports.service.impl.StudentServiceImpl;

import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
@CrossOrigin(origins = "*")
public class AuthController {

    @Autowired
    private StudentServiceImpl studentService;


    // ---------------------------------------------------------
    // REGISTER STUDENT
    // ---------------------------------------------------------
    @PostMapping("/register")
    public ResponseEntity<String> register(@RequestBody Student student) {

        if (studentService.existsByRegdNumber(student.getRegdNumber())) {
            return ResponseEntity.badRequest().body("Registration number already exists!");
        }

        studentService.saveStudent(student);
        return ResponseEntity.ok("Student registered successfully!");
    }


    // ---------------------------------------------------------
    // LOGIN (Creates session)
    // ---------------------------------------------------------
    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody Student student, HttpSession session) {

        Student existingStudent = studentService.findByRegdNumber(student.getRegdNumber());

        if (existingStudent != null &&
                existingStudent.getPassword().equals(student.getPassword())) {

            // ⭐ STORE REG NUMBER IN SESSION
            session.setAttribute("regNumber", existingStudent.getRegdNumber());

            return ResponseEntity.ok("Login successful!");
        }

        return ResponseEntity.status(401).body("Invalid registration number or password");
    }


    // ---------------------------------------------------------
    // LOGOUT (Destroys session)
    // ---------------------------------------------------------
    @PostMapping("/logout")
    public ResponseEntity<?> logout(HttpSession session) {
        session.invalidate();
        return ResponseEntity.ok("Logged out successfully");
    }


    // ---------------------------------------------------------
    // ADMIN LOGIN
    // ---------------------------------------------------------
    @PostMapping("/admin-login")
    public ResponseEntity<String> adminLogin(@RequestBody Admin admin) {

        String adminEmail = "admin@example.com";
        String adminUsername = "admin";
        String adminPassword = "admin123";

        if (admin.getEmail().equals(adminEmail) &&
                admin.getUsername().equals(adminUsername) &&
                admin.getPassword().equals(adminPassword)) {

            return ResponseEntity.ok("Admin login successful");
        }

        return ResponseEntity.status(401).body("Invalid admin credentials");
    }
}

