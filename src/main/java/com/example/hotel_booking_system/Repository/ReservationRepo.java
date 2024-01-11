package com.example.hotel_booking_system.Repository;
import com.example.hotel_booking_system.Model.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReservationRepo extends JpaRepository<Reservation, Integer> {

}
