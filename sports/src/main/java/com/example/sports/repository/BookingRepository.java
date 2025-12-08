//package com.example.sports.repository;
//
//import com.example.sports.dto.BookingDTO;
//import com.example.sports.model.Booking;
//import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.data.jpa.repository.Query;
//import org.springframework.data.repository.query.Param;
//
//import java.time.LocalDate;
//import java.util.List;
//
//public interface BookingRepository extends JpaRepository<Booking, Integer> {
//
//    // Existing method for BookingDTO
//    @Query("""
//        SELECT new com.example.sports.dto.BookingDTO(
//            b.bookingId,
//            b.regdNumber,
//            b.equipmentName,
//            e.imageUrl,
//            b.bookingDate,
//            b.quantity,
//            b.timeSlot,
//            b.status
//        )
//        FROM Booking b
//        LEFT JOIN Equipment e ON b.equipmentName = e.name
//        WHERE b.regdNumber = :regdNumber
//    """)
//    List<BookingDTO> findBookingsWithDetails(@Param("regdNumber") String regdNumber);
//
//    // NEW method to count bookings for a student for the same date/slot
//    @Query("""
//        SELECT COALESCE(SUM(b.quantity), 0)
//        FROM Booking b
//        WHERE b.regdNumber = :regdNumber
//          AND b.equipmentName = :equipmentName
//          AND b.bookingDate = :bookingDate
//          AND b.timeSlot = :timeSlot
//    """)
//    int countExistingBookings(@Param("regdNumber") String regdNumber,
//                              @Param("equipmentName") String equipmentName,
//                              @Param("bookingDate") LocalDate bookingDate,
//                              @Param("timeSlot") String timeSlot);
//}


package com.example.sports.repository;

import com.example.sports.dto.BookingDTO;
import com.example.sports.model.Booking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.List;

public interface BookingRepository extends JpaRepository<Booking, Integer> {

    @Query("""
        SELECT new com.example.sports.dto.BookingDTO(
            b.bookingId,
            b.regdNumber,
            b.equipmentName,
            e.imageUrl,
            b.bookingDate,
            b.quantity,
            b.timeSlot,
            b.status
        )
        FROM Booking b
        LEFT JOIN com.example.sports.model.Equipment e 
               ON b.equipmentName = e.name
        WHERE b.regdNumber = :regdNumber
    """)
    List<BookingDTO> findBookingsWithDetails(@Param("regdNumber") String regdNumber);


    @Query("""
        SELECT COALESCE(SUM(b.quantity), 0)
        FROM Booking b
        WHERE b.regdNumber = :regdNumber
          AND b.equipmentName = :equipmentName
          AND b.bookingDate = :bookingDate
          AND b.timeSlot = :timeSlot
    """)
    int countExistingBookings(@Param("regdNumber") String regdNumber,
                              @Param("equipmentName") String equipmentName,
                              @Param("bookingDate") LocalDate bookingDate,
                              @Param("timeSlot") String timeSlot);
}

