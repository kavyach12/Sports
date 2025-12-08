//package com.example.sports.service;
//
//import com.example.sports.model.Equipment;
//import java.util.List;
//
//public interface EquipmentService {
//    Equipment addEquipment(Equipment equipment);
//    List<Equipment> getAllEquipment();
//    Equipment updateEquipment(Equipment equipment);
//    void deleteEquipment(Long id);
//}

package com.example.sports.service;

import com.example.sports.model.Equipment;
import java.util.List;

public interface EquipmentService {

    Equipment addEquipment(Equipment equipment);

    List<Equipment> getAllEquipment();

    Equipment updateEquipment(Equipment equipment);

    void deleteEquipment(Integer id);

    Equipment getById(Integer id);

    Equipment getByName(String name);
}
