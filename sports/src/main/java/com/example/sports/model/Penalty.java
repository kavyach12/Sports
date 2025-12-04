package com.example.sports.model;

import jakarta.persistence.*;

@Entity
@Table(name = "penalties")
public class Penalty {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "penalty_id")
    private Integer penaltyId;

    @ManyToOne
    @JoinColumn(name = "booking_id", referencedColumnName = "booking_id")
    private Booking booking;

    @Column(nullable = false)
    private Double amount;

    @Column(length = 255)
    private String reason;

    // Getters & Setters
    public Integer getPenaltyId() {
        return penaltyId;
    }

    public void setPenaltyId(Integer penaltyId) {
        this.penaltyId = penaltyId;
    }

    public Booking getBooking() {
        return booking;
    }

    public void setBooking(Booking booking) {
        this.booking = booking;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }
}
