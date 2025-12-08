//package com.example.sports.controller;
//
//import com.example.sports.dto.BookingDTO;
//import com.example.sports.dto.BookingRequest;
//import com.example.sports.model.Booking;
//import com.example.sports.service.BookingService;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.ResponseEntity; // ✅ FIXED IMPORT
//import org.springframework.web.bind.annotation.*;
//
//import java.time.LocalDate;
//import java.util.List;
//
//@RestController
//@RequestMapping("/bookings")
//public class BookingController {
//
//    @Autowired
//    private BookingService bookingService;
//
//    @PostMapping("/create")
//    public ResponseEntity<List<Booking>> create(@RequestBody BookingRequest req) {
//        try {
//            int qty = req.getQuantity() != null ? req.getQuantity() : 1;
//            LocalDate bookingDate = req.getBookingDate() != null ? req.getBookingDate() : LocalDate.now();
//
//            List<Booking> saved = bookingService.createMany(
//                    req.getRegdNumber(),
//                    req.getEquipmentName(),
//                    qty,
//                    bookingDate,
//                    req.getTimeSlot()
//            );
//
//            return ResponseEntity.ok(saved);
//        } catch (Exception e) {
//            e.printStackTrace();
//            return ResponseEntity.status(500).body(null);
//        }
//    }
//
//    @GetMapping("/all")
//    public ResponseEntity<List<Booking>> getAll() {
//        return ResponseEntity.ok(bookingService.getAllBookings());
//    }
//
//    @GetMapping("/by-student/{regdNumber}")
//    public ResponseEntity<List<BookingDTO>> getByStudent(@PathVariable String regdNumber) {
//        return ResponseEntity.ok(bookingService.getBookingsWithDetails(regdNumber));
//    }
//}


//package com.example.sports.controller;
//
//import com.example.sports.dto.BookingDTO;
//import com.example.sports.model.Booking;
//import com.example.sports.model.Equipment;
//import com.example.sports.service.BookingService;
//import com.example.sports.service.EquipmentService;
//
//import jakarta.servlet.http.HttpSession;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.*;
//
//import java.time.LocalDate;
//import java.util.List;
//
//@RestController
//@RequestMapping("/api/bookings")
//@CrossOrigin(origins = "http://localhost:8080")
//public class BookingController {
//
//    @Autowired
//    private BookingService bookingService;
//
//    @Autowired
//    private EquipmentService equipmentService;
//
//
//    // -----------------------------------------------------
//    // Create booking for logged-in user
//    // -----------------------------------------------------
//    @PostMapping("/create")
//    public String createBooking(
//            @RequestParam String equipmentName,
//            @RequestParam int quantity,
//            @RequestParam String timeSlot,
//            @RequestParam String bookingDate,
//            HttpSession session
//    ) {
//
//        // Get logged-in user's registration number
//        String regNumber = (String) session.getAttribute("regNumber");
//        if (regNumber == null) {
//            return "ERROR: User is not logged in.";
//        }
//
//        // Validate equipment
//        Equipment equipment = equipmentService.getByName(equipmentName);
//        if (equipment == null) {
//            return "ERROR: Equipment not found.";
//        }
//
//        // Check stock availability
//        if (equipment.getQuantity() < quantity) {
//            return "ERROR: Only " + equipment.getQuantity() + " items available.";
//        }
//
//        // Convert date
//        LocalDate date = LocalDate.parse(bookingDate);
//
//        // Create bookings
//        bookingService.createMany(
//                regNumber,
//                equipmentName,
//                quantity,
//                date,
//                timeSlot
//        );
//
//        // Update stock
//        equipment.setQuantity(equipment.getQuantity() - quantity);
//        equipmentService.updateEquipment(equipment);
//
//        return "SUCCESS: Booking completed!";
//    }
//
//
//    // -----------------------------------------------------
//    // Get all bookings (Admin)
//    // -----------------------------------------------------
//    @GetMapping("/all")
//    public List<Booking> getAllBookings() {
//        return bookingService.getAllBookings();
//    }
//
//
//    // -----------------------------------------------------
//    // Get logged-in user's bookings
//    // -----------------------------------------------------
//    @GetMapping("/my")
//    public List<BookingDTO> getMyBookings(HttpSession session) {
//
//        String regNumber = (String) session.getAttribute("regNumber");
//
//        if (regNumber == null) {
//            return null;
//        }
//
//        return bookingService.getBookingsWithDetails(regNumber);
//    }
//
//
//    // -----------------------------------------------------
//    // Get bookings for any student (Admin)
//    // -----------------------------------------------------
//    @GetMapping("/student/{regNumber}")
//    public List<BookingDTO> getByStudent(@PathVariable String regNumber) {
//        return bookingService.getBookingsWithDetails(regNumber);
//    }
//}

//package com.example.sports.controller;
//
//import com.example.sports.dto.BookingDTO;
//import com.example.sports.model.Booking;
//import com.example.sports.model.Equipment;
//import com.example.sports.service.BookingService;
//import com.example.sports.service.EquipmentService;
//import com.example.sports.dto.BookingRequest;
//
//
//import jakarta.servlet.http.HttpSession;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.*;
//
//import java.time.LocalDate;
//import java.util.List;
//
//@RestController
//@RequestMapping("/bookings")   // changed to match your frontend URL
//@CrossOrigin(origins = "*")
//public class BookingController {
//
//    @Autowired
//    private BookingService bookingService;
//
//    @Autowired
//    private EquipmentService equipmentService;
//

    // -----------------------------------------------------
    // Create Booking for Logged-in User
    // -----------------------------------------------------
//    @PostMapping("/create")
//    public String createBooking(
//            @RequestParam String equipmentName,
//            @RequestParam int quantity,
//            @RequestParam String timeSlot,
//            @RequestParam String bookingDate,
//            HttpSession session
//    ) {
//
//        String regNumber = (String) session.getAttribute("regNumber");
//
//        if (regNumber == null) {
//            return "ERROR: User is not logged in.";
//        }
//
//        // Validate equipment
//        Equipment equipment = equipmentService.getByName(equipmentName);
//        if (equipment == null) {
//            return "ERROR: Equipment not found.";
//        }
//
//        // Check available stock
//        if (equipment.getTotalQuantity() < quantity) {
//            return "ERROR: Only " + equipment.getTotalQuantity() + " items available.";
//        }
//
//        // Convert date
//        LocalDate date = LocalDate.parse(bookingDate);
//
//        // Create booking
//        bookingService.createMany(
//                regNumber,
//                equipmentName,
//                quantity,
//                date,
//                timeSlot
//        );
//
//        // Update stock
//        equipment.setTotalQuantity(equipment.getTotalQuantity() - quantity);
//        equipmentService.updateEquipment(equipment);
//
//        return "SUCCESS: Booking completed!";
//    }

//

//package com.example.sports.controller;
//
//import com.example.sports.dto.BookingDTO;
//import com.example.sports.dto.BookingRequest;
//import com.example.sports.model.Booking;
//import com.example.sports.model.Equipment;
//import com.example.sports.service.BookingService;
//import com.example.sports.service.EquipmentService;
//import com.example.sports.repository.EquipmentRepository;
//
//import jakarta.servlet.http.HttpSession;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//
//import java.time.LocalDate;
//import java.util.List;
//
//@RestController
//@RequestMapping("/bookings")
//@CrossOrigin(origins = "*")
//public class BookingController {
//
//    @Autowired
//    private BookingService bookingService;
//
//    @Autowired
//    private EquipmentService equipmentService;
//
//
//    // -----------------------------------------------------
//    // CREATE BOOKING (JSON body)
//    // -----------------------------------------------------
//    @PostMapping("/create")
//    public ResponseEntity<?> createBooking(@RequestBody BookingRequest req, HttpSession session) {
//
//        String regNumber = (String) session.getAttribute("regNumber");
//
//        if (regNumber == null) {
//            return ResponseEntity.status(401).body("User not logged in");
//        }
//
//        // Validate equipment
//        Equipment equipment = equipmentService.getByName(req.getEquipmentName());
//        if (equipment == null) {
//            return ResponseEntity.badRequest().body("Equipment not found");
//        }
//
//        if (req.getQuantity() > equipment.getTotalQuantity()) {
//            return ResponseEntity.badRequest()
//                    .body("Only " + equipment.getTotalQuantity() + " items available");
//        }
//
//        LocalDate bookingDate = req.getBookingDate() != null
//                ? LocalDate.parse(req.getBookingDate())
//                : LocalDate.now();
//
//        try {
//            // Create booking record(s)
//            bookingService.createMany(
//                    regNumber,
//                    req.getEquipmentName(),
//                    req.getQuantity(),
//                    bookingDate,
//                    req.getTimeSlot()
//            );
//
//            // Update available quantity
//            equipment.setTotalQuantity(equipment.getTotalQuantity() - req.getQuantity());
//            equipmentService.updateEquipment(equipment);
//
//
//
//            return ResponseEntity.ok("Booking completed successfully!");
//
//        } catch (Exception ex) {
//            return ResponseEntity.status(400).body(ex.getMessage());
//        }
//    }
//
//
//    // -----------------------------------------------------
//    // MY BOOKINGS (SECURE — Uses Session)
//    // -----------------------------------------------------
//    @GetMapping("/my")
//    public ResponseEntity<?> getMyBookings(HttpSession session) {
//
//        String regNumber = (String) session.getAttribute("regNumber");
//
//        if (regNumber == null) {
//            return ResponseEntity.ok(List.of());
//        }
//
//        List<BookingDTO> bookings = bookingService.getBookingsWithDetails(regNumber);
//        return ResponseEntity.ok(bookings);
//    }
//
//
//    // -----------------------------------------------------
//    // ADMIN — Get all bookings
//    // -----------------------------------------------------
//    @GetMapping("/all")
//    public ResponseEntity<List<Booking>> getAllBookings() {
//        return ResponseEntity.ok(bookingService.getAllBookings());
//    }
//}


package com.example.sports.controller;

import com.example.sports.dto.BookingDTO;
import com.example.sports.dto.BookingRequest;
import com.example.sports.model.Booking;
import com.example.sports.model.Equipment;
import com.example.sports.service.BookingService;
import com.example.sports.service.EquipmentService;

import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/bookings")
@CrossOrigin(origins = "*")
public class BookingController {

    @Autowired
    private BookingService bookingService;

    @Autowired
    private EquipmentService equipmentService;


    // -----------------------------------------------------
    // CREATE BOOKING (JSON body)
    // -----------------------------------------------------
    @PostMapping("/create")
    public ResponseEntity<?> createBooking(@RequestBody BookingRequest req, HttpSession session) {

        // ✔ Get logged-in student's registration number
        String regNumber = (String) session.getAttribute("regNumber");
        if (regNumber == null) {
            return ResponseEntity.status(401).body("User not logged in");
        }

        // ✔ Validate equipment
        Equipment equipment = equipmentService.getByName(req.getEquipmentName());
        if (equipment == null) {
            return ResponseEntity.badRequest().body("Equipment not found");
        }

        // ✔ Check available stock
        if (req.getQuantity() > equipment.getTotalQuantity()) {
            return ResponseEntity.badRequest()
                    .body("Only " + equipment.getTotalQuantity() + " items available");
        }

        // ✔ Use LocalDate from DTO (already LocalDate)
        LocalDate bookingDate = req.getBookingDate() != null
                ? req.getBookingDate()
                : LocalDate.now();

        try {
            // ✔ Create booking record
            bookingService.createMany(
                    regNumber,
                    req.getEquipmentName(),
                    req.getQuantity(),
                    bookingDate,
                    req.getTimeSlot()
            );

            // ✔ Update equipment stock
            int updatedQty = equipment.getTotalQuantity() - req.getQuantity();
            equipment.setTotalQuantity(updatedQty);

            equipmentService.updateEquipment(equipment); // force save

            return ResponseEntity.ok(equipmentService.getAllEquipment());

        } catch (Exception ex) {
            return ResponseEntity.status(400).body(ex.getMessage());
        }
    }


    // -----------------------------------------------------
    // MY BOOKINGS (Uses Session)
    // -----------------------------------------------------
    @GetMapping("/my")
    public ResponseEntity<?> getMyBookings(HttpSession session) {

        String regNumber = (String) session.getAttribute("regNumber");

        // If not logged in → return empty list (so frontend doesn't break)
        if (regNumber == null) {
            return ResponseEntity.ok(List.of());
        }

        List<BookingDTO> bookings = bookingService.getBookingsWithDetails(regNumber);
        return ResponseEntity.ok(bookings);
    }


    // -----------------------------------------------------
    // ADMIN — Get all bookings
    // -----------------------------------------------------
    @GetMapping("/all")
    public ResponseEntity<List<Booking>> getAllBookings() {
        return ResponseEntity.ok(bookingService.getAllBookings());
    }
}
