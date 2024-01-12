package com.example.hotel_booking_system.Service;

import com.example.hotel_booking_system.DTO.RoomDTO;
import com.example.hotel_booking_system.Model.Hotel;
import com.example.hotel_booking_system.Model.Room;
import com.example.hotel_booking_system.Repository.HotelRepo;
import com.example.hotel_booking_system.Repository.RoomRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class RoomService {

    private final RoomRepo roomRepo;
    private final HotelRepo hotelRepo;
    private final RoomDTO roomDTO;

    @Autowired
    public RoomService(RoomRepo roomRepo, HotelRepo hotelRepo, RoomDTO roomDTO) {
        this.roomRepo = roomRepo;
        this.hotelRepo = hotelRepo;
        this.roomDTO = roomDTO;
    }

    public Room addRoomToHotel(int hotelId, RoomDTO roomDTO) {
        // Check if the hotel with the given ID exists
        Hotel hotel = hotelRepo.findById(hotelId).orElse(null);
        if (hotel == null) {
            // Handle the case where the hotel is not found
            return null;
        }

        Room room = new Room();
        room.setRoomNumber(roomDTO.getRoomNumber());
        room.setNumberOfBeds(roomDTO.getNumberOfBeds());
        room.setFloor(roomDTO.getFloor());
        room.setRoomType(roomDTO.getRoomType());
        room.setPricePerNight(roomDTO.getPricePerNight());
        room.setCreated(LocalDateTime.now());
        room.setUpdated(LocalDateTime.now());
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
