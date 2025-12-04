package com.example.sports.model;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "bookings")
public class Booking {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "booking_id")
    private Integer bookingId;

    @Column(name = "regd_number", nullable = false)
    private String regdNumber;

    @Column(name = "equipment_name", nullable = false)
    private String equipmentName;

    @Column(name = "quantity", nullable = false)
    private int quantity;

    @Column(name = "booking_date", nullable = false)
    private LocalDate bookingDate;

    @Column(name = "time_slot", nullable = false)
    private String timeSlot;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Status status = Status.booked;

    public enum Status {
        booked, returned, late
    }

    public Booking() {}

    // Getters & Setters
    public Integer getBookingId() { return bookingId; }
    public void setBookingId(Integer bookingId) { this.bookingId = bookingId; }

    public String getRegdNumber() { return regdNumber; }
    public void setRegdNumber(String regdNumber) { this.regdNumber = regdNumber; }

    public String getEquipmentName() { return equipmentName; }
    public void setEquipmentName(String equipmentName) { this.equipmentName = equipmentName; }

    public int getQuantity() { return quantity; }
    public void setQuantity(int quantity) { this.quantity = quantity; }

    public LocalDate getBookingDate() { return bookingDate; }
    public void setBookingDate(LocalDate bookingDate) { this.bookingDate = bookingDate; }

    public String getTimeSlot() { return timeSlot; }
    public void setTimeSlot(String timeSlot) { this.timeSlot = timeSlot; }

    public Status getStatus() { return status; }
    public void setStatus(Status status) { this.status = status; }
}
