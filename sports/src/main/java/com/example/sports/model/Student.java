package com.example.sports.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "students")
public class Student {

    @Id
    private String regdNumber;  // Primary key, e.g., 23b91a1223

    private String name;
    private String email;
    private String phone;
    private String password; // Encrypted

    // Getters and Setters
    public String getRegdNumber() {
        return regdNumber;
    }
    public void setRegdNumber(String regdNumber) {
        this.regdNumber = regdNumber;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getPhone() {
        return phone;
    }
    public void setPhone(String phone) {
        this.phone = phone;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
}
