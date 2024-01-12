package com.example.hotel_booking_system.Service;

import com.example.hotel_booking_system.Model.Hotel;
import com.example.hotel_booking_system.Model.Room;
import com.example.hotel_booking_system.Repository.HotelRepo;
import com.example.hotel_booking_system.Repository.RoomRepo;
import org.apache.velocity.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoomService {

    private final RoomRepo roomRepo;
    private final HotelRepo hotelRepo;

    @Autowired
    public RoomService(RoomRepo roomRepo, HotelRepo hotelRepo) {
        this.roomRepo = roomRepo;
        this.hotelRepo = hotelRepo;
    }

    public Room addRoomToHotel(int hotelId, Room room) {
        Hotel hotel = hotelRepo.findById(hotelId)
                .orElseThrow(() -> new ResourceNotFoundException("Hotel not found with id: " + hotelId));
        room.setHotel(hotel);
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
