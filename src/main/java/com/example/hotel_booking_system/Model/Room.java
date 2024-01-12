package com.example.hotel_booking_system.Model;

import com.example.hotel_booking_system.Enum.RoomType;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@Entity
@NoArgsConstructor
public class Room {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private int roomNumber;
    private int numberOfBeds;
    private int floor;
    private RoomType roomType;
    private int pricePerNight;

    private LocalDateTime created;
    private LocalDateTime updated;

    @ManyToOne
    private Hotel hotel;

    @OneToMany(mappedBy = "room", cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private List<Reservation> reservations;

    public Room(int id, int roomNumber, int numberOfBeds, int floor, RoomType roomType, int pricePerNight, LocalDateTime created, LocalDateTime updated, Hotel hotel, List<Reservation> reservations) {
        this.id = id;
        this.roomNumber = roomNumber;
        this.numberOfBeds = numberOfBeds;
        this.floor = floor;
        this.roomType = roomType;
        this.pricePerNight = pricePerNight;
        this.created = created;
        this.updated = updated;
        this.hotel = hotel;
        this.reservations = reservations;
    }
}
