package com.example.sports.controller;

import com.example.sports.model.Equipment;
import com.example.sports.repository.EquipmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/equipment")
public class EquipmentController {

    @Autowired
    private EquipmentRepository equipmentRepository;

    // 1️⃣ Get all equipment
    @GetMapping
    public List<Equipment> getAllEquipment() {
        return equipmentRepository.findAll();
    }

    // 2️⃣ Get equipment by ID
    @GetMapping("/{id}")
    public Equipment getEquipmentById(@PathVariable int id) {
        return equipmentRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Equipment not found with id: " + id));
    }

    // 3️⃣ Add new equipment
    @PostMapping
    public Equipment addEquipment(@RequestBody Equipment equipment) {
        return equipmentRepository.save(equipment);
    }

    // 4️⃣ Update equipment
    @PutMapping("/{id}")
    public Equipment updateEquipment(@PathVariable int id, @RequestBody Equipment updatedEquipment) {
        Equipment existing = equipmentRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Equipment not found with id: " + id));

        existing.setName(updatedEquipment.getName());
        existing.setType(updatedEquipment.getType());
        existing.setTotalQuantity(updatedEquipment.getTotalQuantity());
        existing.setAvailableQuantity(updatedEquipment.getAvailableQuantity());

        return equipmentRepository.save(existing);
    }

    // 5️⃣ Delete equipment
    @DeleteMapping("/{id}")
    public String deleteEquipment(@PathVariable int id) {
        equipmentRepository.deleteById(id);
        return "Equipment deleted successfully!";
    }
}
