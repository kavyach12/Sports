package com.example.sports.service.impl;

import com.example.sports.model.Equipment;
import com.example.sports.repository.EquipmentRepository;
import com.example.sports.service.EquipmentService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EquipmentServiceImpl implements EquipmentService {

    @Autowired
    private EquipmentRepository equipmentRepository;

    @Override
    public Equipment addEquipment(Equipment equipment) {
        return equipmentRepository.save(equipment);
    }

    @Override
    public List<Equipment> getAllEquipment() {
        return equipmentRepository.findAll();
    }

    @Override
    public Equipment updateEquipment(Equipment equipment) {
        return equipmentRepository.save(equipment);
    }

    @Override
    public void deleteEquipment(Integer id) {
        equipmentRepository.deleteById(id);
    }

    @Override
    public Equipment getById(Integer id) {
        return equipmentRepository.findById(id).orElse(null);
    }

    @Override
    public Equipment getByName(String name) {
        return equipmentRepository.findByNameIgnoreCase(name).orElse(null);
    }
}
