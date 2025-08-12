package com.example.sports.service.impl;

import com.example.sports.model.Booking;
import com.example.sports.repository.BookingRepository;
import com.example.sports.service.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookingServiceImpl implements BookingService {

    @Autowired
    private BookingRepository bookingRepository;

    @Override
    public Booking createBooking(Booking booking) {
        // Save the booking to the database
        return bookingRepository.save(booking);
    }

    @Override
    public List<Booking> getAllBookings() {
        // Retrieve all bookings from the database
        return bookingRepository.findAll();
    }
}
