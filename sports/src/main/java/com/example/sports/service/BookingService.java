package com.example.sports.service;

import com.example.sports.dto.BookingDTO;
import com.example.sports.model.Booking;

import java.time.LocalDate;
import java.util.List;

public interface BookingService {
    Booking createOne(Booking booking);
    List<Booking> createMany(String regdNumber, String equipmentName, int quantity,
                             LocalDate bookingDate, String timeSlot);
    List<Booking> getAllBookings();
    List<Booking> getByStudent(String regdNumber);
    List<BookingDTO> getBookingsWithDetails(String regdNumber);
}
