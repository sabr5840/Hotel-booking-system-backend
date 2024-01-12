package com.example.hotel_booking_system.DTO;

import com.example.hotel_booking_system.Enum.RoomType;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;


@Getter
@Setter
@Component
public class RoomDTO {

    private int id;
    private int roomNumber;

    public int getId() {
        return id;
    }

    public int getRoomNumber() {
        return roomNumber;
    }

    public int getNumberOfBeds() {
        return numberOfBeds;
    }

    public int getFloor() {
        return floor;
    }

    public RoomType getRoomType() {
        return roomType;
    }

    public int getPricePerNight() {
        return pricePerNight;
    }

    public int getHotelId() {
        return hotelId;
    }

    private int numberOfBeds;
    private int floor;
    private RoomType roomType;
    private int pricePerNight;
    private int hotelId;


    public RoomDTO(int id, int roomNumber, int numberOfBeds, int floor, RoomType roomType, int pricePerNight, int hotelId) {
        this.id = id;
        this.roomNumber = roomNumber;
        this.numberOfBeds = numberOfBeds;
        this.floor = floor;
        this.roomType = roomType;
        this.pricePerNight = pricePerNight;
        this.hotelId = hotelId;

    }


    // No-argument constructor (can be used by frameworks)
    public RoomDTO() {
    }
}
