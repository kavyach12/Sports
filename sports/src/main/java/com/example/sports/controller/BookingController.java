package com.example.sports.controller;

import com.example.sports.dto.BookingDTO;
import com.example.sports.dto.BookingRequest;
import com.example.sports.model.Booking;
import com.example.sports.service.BookingService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity; // ✅ FIXED IMPORT
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/bookings")
public class BookingController {

    @Autowired 
    private BookingService bookingService;

    @PostMapping("/create")
    public ResponseEntity<List<Booking>> create(@RequestBody BookingRequest req) {
        try {
            int qty = req.getQuantity() != null ? req.getQuantity() : 1;
            LocalDate bookingDate = req.getBookingDate() != null ? req.getBookingDate() : LocalDate.now();

            List<Booking> saved = bookingService.createMany(
                    req.getRegdNumber(),
                    req.getEquipmentName(),
                    qty,
                    bookingDate,
                    req.getTimeSlot()
            );

            return ResponseEntity.ok(saved);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(500).body(null);
        }
    }

    @GetMapping("/all")
    public ResponseEntity<List<Booking>> getAll() {
        return ResponseEntity.ok(bookingService.getAllBookings());
    }

    @GetMapping("/by-student/{regdNumber}")
    public ResponseEntity<List<BookingDTO>> getByStudent(@PathVariable String regdNumber) {
        return ResponseEntity.ok(bookingService.getBookingsWithDetails(regdNumber));
    }
}
