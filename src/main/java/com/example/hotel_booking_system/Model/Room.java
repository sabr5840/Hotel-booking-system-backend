package com.example.hotel_booking_system.Model;

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
    private int roomId;

    private int roomNumber;
    private int numberOfBeds;
    private int floor;
    private String roomType;
    private int price;

    private LocalDateTime created;
    private LocalDateTime updated;

    @ManyToOne
    private Hotel hotel;

    @OneToMany(mappedBy = "room", cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private List<Reservation> reservations;

    public Room(int roomId, int roomNumber, int numberOfBeds, int floor, String roomType, int price, LocalDateTime created, LocalDateTime updated, Hotel hotel, List<Reservation> reservations) {
        this.roomId = roomId;
        this.roomNumber = roomNumber;
        this.numberOfBeds = numberOfBeds;
        this.floor = floor;
        this.roomType = roomType;
        this.price = price;
        this.created = created;
        this.updated = updated;
        this.hotel = hotel;
        this.reservations = reservations;
    }
}
