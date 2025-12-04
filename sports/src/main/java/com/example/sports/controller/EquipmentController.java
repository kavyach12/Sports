package com.example.sports.controller;

import com.example.sports.model.Equipment;
import com.example.sports.repository.EquipmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/equipment")
public class EquipmentController {

    @Autowired
    private EquipmentRepository equipmentRepository;

    /**
     * Get all equipment
     */
    @GetMapping
    public ResponseEntity<List<Equipment>> getAllEquipment() {
        return ResponseEntity.ok(equipmentRepository.findAll());
    }

    /**
     * Get equipment by ID
     */
    @GetMapping("/{id}")
    public ResponseEntity<Equipment> getEquipmentById(@PathVariable int id) {
        Equipment equipment = equipmentRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,
                        "Equipment not found with ID: " + id));
        return ResponseEntity.ok(equipment);
    }

    /**
     * Get maxPerBooking limit by equipment name
     */
    @GetMapping("/limit/{name}")
    public ResponseEntity<Map<String, Integer>> getEquipmentLimit(@PathVariable String name) {
    Equipment equipment = equipmentRepository.findByName(name)
            .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,
                    "Equipment not found with name: " + name));

    return ResponseEntity.ok(Map.of("maxPerBooking", equipment.getMaxPerBooking()));
}


    /**
     * Add new equipment
     */
    @PostMapping
    public ResponseEntity<Equipment> addEquipment(@RequestBody Equipment equipment) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(equipmentRepository.save(equipment));
    }

    /**
     * Update existing equipment
     */
    @PutMapping("/{id}")
    public ResponseEntity<Equipment> updateEquipment(@PathVariable int id,
                                                     @RequestBody Equipment updatedEquipment) {
        Equipment existing = equipmentRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,
                        "Equipment not found with ID: " + id));

        existing.setName(updatedEquipment.getName());
        existing.setType(updatedEquipment.getType());
        existing.setTotalQuantity(updatedEquipment.getTotalQuantity());
        existing.setImageUrl(updatedEquipment.getImageUrl());
        existing.setMaxPerBooking(updatedEquipment.getMaxPerBooking());

        return ResponseEntity.ok(equipmentRepository.save(existing));
    }

    /**
     * Delete equipment
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteEquipment(@PathVariable int id) {
        if (!equipmentRepository.existsById(id)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,
                    "Equipment not found with ID: " + id);
        }
        equipmentRepository.deleteById(id);
        return ResponseEntity.ok("Equipment deleted successfully!");
    }
}
