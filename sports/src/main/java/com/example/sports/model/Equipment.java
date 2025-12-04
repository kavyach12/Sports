package com.example.sports.model;

import jakarta.persistence.*;

@Entity
@Table(name = "equipment")
public class Equipment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "equipment_id")
    private Integer equipmentId;

    @Column(nullable = false, length = 100)
    private String name;

    @Column(length = 50)
    private String type;

    @Column(name = "total_quantity", nullable = false)
    private Integer totalQuantity;

    @Column(name = "image_url", length = 255)
    private String imageUrl; // ✅ New column

    @Column(name = "count")
    private int maxPerBooking;



    // Getters & Setters
    public Integer getEquipmentId() {
        return equipmentId;
    }

    public void setEquipmentId(Integer equipmentId) {
        this.equipmentId = equipmentId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Integer getTotalQuantity() {
        return totalQuantity;
    }

    public void setTotalQuantity(Integer totalQuantity) {
        this.totalQuantity = totalQuantity;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    
    // getter and setter
    public int getMaxPerBooking() {
        return maxPerBooking;
    }

    public void setMaxPerBooking(int maxPerBooking) {
        this.maxPerBooking = maxPerBooking;
    }
}
