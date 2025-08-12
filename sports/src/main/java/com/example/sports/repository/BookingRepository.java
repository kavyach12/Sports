package com.example.sports.repository;

import com.example.sports.model.Booking;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BookingRepository extends JpaRepository<Booking, Integer> {
    // Find all bookings for a particular student
    List<Booking> findByRegdNumber(String regdNumber);
}
