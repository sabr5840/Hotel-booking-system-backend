package com.example.hotel_booking_system.Repository;
import com.example.hotel_booking_system.Model.Hotel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HotelRepo extends JpaRepository<Hotel, Integer> {

}
