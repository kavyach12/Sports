package com.example.sports.service.impl;

import com.example.sports.dto.BookingDTO;
import com.example.sports.model.Booking;
import com.example.sports.model.Equipment;
import com.example.sports.repository.BookingRepository;
import com.example.sports.repository.EquipmentRepository;
import com.example.sports.service.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
public class BookingServiceImpl implements BookingService {

    @Autowired
    private BookingRepository bookingRepository;

    @Autowired
    private EquipmentRepository equipmentRepository;

    @Override
    public Booking createOne(Booking booking) {
        return bookingRepository.save(booking);
    }

    @Override
    public List<Booking> createMany(String regdNumber, String equipmentName, int quantity,
                                    LocalDate bookingDate, String timeSlot) {

        if (quantity <= 0) {
            throw new IllegalArgumentException("Quantity must be greater than 0");
        }

        // 1️⃣ Fetch equipment details
        Equipment equipment = equipmentRepository.findAll().stream()
                .filter(e -> e.getName().equalsIgnoreCase(equipmentName))
                .findFirst()
                .orElseThrow(() -> new RuntimeException("Equipment not found"));

        int limit = equipment.getMaxPerBooking();

        // 2️⃣ Count existing bookings for same date & slot
        int alreadyBookedQty = bookingRepository.countExistingBookings(
                regdNumber, equipmentName, bookingDate, timeSlot
        );

        // 3️⃣ Check if limit exceeded
        if (alreadyBookedQty + quantity > limit) {
            throw new RuntimeException("Booking limit exceeded for this equipment");
        }

        // 4️⃣ Save booking
        List<Booking> created = new ArrayList<>();
        Booking b = new Booking();
        b.setRegdNumber(regdNumber);
        b.setEquipmentName(equipmentName);
        b.setQuantity(quantity);
        b.setBookingDate(bookingDate != null ? bookingDate : LocalDate.now());
        b.setTimeSlot(timeSlot);
        b.setStatus(Booking.Status.booked);

        created.add(bookingRepository.save(b));
        return created;
    }

    @Override
    public List<Booking> getAllBookings() {
        return bookingRepository.findAll();
    }

    @Override
    public List<BookingDTO> getBookingsWithDetails(String regdNumber) {
        return bookingRepository.findBookingsWithDetails(regdNumber);
    }

    @Override
    public List<Booking> getByStudent(String regdNumber) {
        return bookingRepository.findAll()
                .stream()
                .filter(b -> b.getRegdNumber().equals(regdNumber))
                .toList();
    }
}
