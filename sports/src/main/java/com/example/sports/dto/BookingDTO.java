package com.example.sports.dto;

import java.time.LocalDate;

import com.example.sports.model.Booking;

public class BookingDTO {
    private Integer bookingId;
    private String regdNumber;
    private String equipmentName;
    private String equipmentImage;
    private LocalDate bookingDate;
    private int quantity;
    private String timeSlot;
    private String status;

    public BookingDTO() {}

    public BookingDTO(
    Integer bookingId,
    String regdNumber,
    String equipmentName,
    String equipmentImage,
    LocalDate bookingDate,
    int quantity,
    String timeSlot,
    Booking.Status status // <- change type here
) {
    this.bookingId = bookingId;
    this.regdNumber = regdNumber;
    this.equipmentName = equipmentName;
    this.equipmentImage = equipmentImage;
    this.bookingDate = bookingDate;
    this.quantity = quantity;
    this.timeSlot = timeSlot;
    this.status = status.name(); // convert to String internally
}


    // Getters & Setters
    public Integer getBookingId() { return bookingId; }
    public void setBookingId(Integer bookingId) { this.bookingId = bookingId; }
    public String getRegdNumber() { return regdNumber; }
    public void setRegdNumber(String regdNumber) { this.regdNumber = regdNumber; }
    public String getEquipmentName() { return equipmentName; }
    public void setEquipmentName(String equipmentName) { this.equipmentName = equipmentName; }
    public String getEquipmentImage() { return equipmentImage; }
    public void setEquipmentImage(String equipmentImage) { this.equipmentImage = equipmentImage; }
    public LocalDate getBookingDate() { return bookingDate; }
    public void setBookingDate(LocalDate bookingDate) { this.bookingDate = bookingDate; }
    public int getQuantity() { return quantity; }
    public void setQuantity(int quantity) { this.quantity = quantity; }
    public String getTimeSlot() { return timeSlot; }
    public void setTimeSlot(String timeSlot) { this.timeSlot = timeSlot; }
    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }
}
