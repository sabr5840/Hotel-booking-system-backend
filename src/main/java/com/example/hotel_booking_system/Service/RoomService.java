package com.example.hotel_booking_system.Service;

import com.example.hotel_booking_system.Model.Room;
import com.example.hotel_booking_system.Repository.RoomRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoomService {

    private final RoomRepo roomRepo;

    @Autowired
    public RoomService(RoomRepo roomRepo) {
        this.roomRepo = roomRepo;
    }

    public Room addRoom(Room room) {
        return roomRepo.save(room);
    }

    public List<Room> findRoomsByHotelId(int hotelId) {
        return roomRepo.findRoomsByHotelId(hotelId);
    }

    public Room updateRoom(Room room) {
        return roomRepo.save(room);
    }

    public void deleteRoom(int id) {
        roomRepo.deleteById(id);
    }

}
