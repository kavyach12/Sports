//package com.example.sports.service;
//
//import com.example.sports.dto.BookingDTO;
//import com.example.sports.model.Booking;
//
//import java.time.LocalDate;
//import java.util.List;
//
//public interface BookingService {
//    Booking createOne(Booking booking);
//    List<Booking> createMany(String regdNumber, String equipmentName, int quantity,
//                             LocalDate bookingDate, String timeSlot);
//    List<Booking> getAllBookings();
//    List<Booking> getByStudent(String regdNumber);
//    List<BookingDTO> getBookingsWithDetails(String regdNumber);
//}

package com.example.sports.service;

import com.example.sports.dto.BookingDTO;
import com.example.sports.model.Booking;

import java.time.LocalDate;
import java.util.List;

public interface BookingService {

    // Create a single booking entry
    Booking createOne(Booking booking);

    // Create booking entries for multiple quantities of equipment
    List<Booking> createMany(
            String regdNumber,
            String equipmentName,
            int quantity,
            LocalDate bookingDate,
            String timeSlot
    );

    // Fetch all bookings (Admin)
    List<Booking> getAllBookings();

    // Fetch bookings for a specific student
    List<Booking> getByStudent(String regdNumber);

    // Fetch bookings with full details (joins with Equipment)
    List<BookingDTO> getBookingsWithDetails(String regdNumber);
}

