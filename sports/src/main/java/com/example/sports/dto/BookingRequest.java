//package com.example.sports.dto;
//
//import java.time.LocalDate;
//
//public class BookingRequest {
//    private String regdNumber;
//    private String equipmentName;
//    private Integer quantity;
//    private LocalDate bookingDate;
//    private String timeSlot;
//
//    public String getRegdNumber() { return regdNumber; }
//    public void setRegdNumber(String regdNumber) { this.regdNumber = regdNumber; }
//
//    public String getEquipmentName() { return equipmentName; }
//    public void setEquipmentName(String equipmentName) { this.equipmentName = equipmentName; }
//
//    public Integer getQuantity() { return quantity; }
//    public void setQuantity(Integer quantity) { this.quantity = quantity; }
//
//    public LocalDate getBookingDate() { return bookingDate; }
//    public void setBookingDate(LocalDate bookingDate) { this.bookingDate = bookingDate; }
//
//    public String getTimeSlot() { return timeSlot; }
//    public void setTimeSlot(String timeSlot) { this.timeSlot = timeSlot; }
//}


package com.example.sports.dto;

public class BookingRequest {
    private String regdNumber;
    private String equipmentName;
    private Integer quantity;
    private String bookingDate;   // FIXED: LocalDate -> String
    private String timeSlot;

    public String getRegdNumber() { return regdNumber; }
    public void setRegdNumber(String regdNumber) { this.regdNumber = regdNumber; }

    public String getEquipmentName() { return equipmentName; }
    public void setEquipmentName(String equipmentName) { this.equipmentName = equipmentName; }

    public Integer getQuantity() { return quantity; }
    public void setQuantity(Integer quantity) { this.quantity = quantity; }

    public String getBookingDate() { return bookingDate; }
    public void setBookingDate(String bookingDate) { this.bookingDate = bookingDate; }

    public String getTimeSlot() { return timeSlot; }
    public void setTimeSlot(String timeSlot) { this.timeSlot = timeSlot; }
}
