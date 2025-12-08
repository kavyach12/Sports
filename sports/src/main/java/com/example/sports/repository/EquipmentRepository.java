//package com.example.sports.repository;
//
//import com.example.sports.model.Equipment;
//import org.springframework.data.jpa.repository.JpaRepository;
//import java.util.Optional;
//
//public interface EquipmentRepository extends JpaRepository<Equipment, Integer> {
//
//    // ✅ Finds equipment by name (case-sensitive or change to IgnoreCase if needed)
//    Optional<Equipment> findByName(String name);
//}


package com.example.sports.repository;

import com.example.sports.model.Equipment;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface EquipmentRepository extends JpaRepository<Equipment, Integer> {

    // Find equipment by exact name (case sensitive)
    Optional<Equipment> findByName(String name);

    // Find equipment by name (case insensitive)
    Optional<Equipment> findByNameIgnoreCase(String name);
}
