package com.example.hotel_booking_system.Repository;
import com.example.hotel_booking_system.Model.Room;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RoomRepo extends JpaRepository<Room, Integer> {

    List<Room> findRoomsByHotelId(int hotelId);
}
