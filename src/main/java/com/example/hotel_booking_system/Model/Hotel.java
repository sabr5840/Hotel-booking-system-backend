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
public class Hotel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int hotelId;

    private String name;
    private String street;
    private String city;
    private int zip;
    private String country;
    private LocalDateTime created;
    private LocalDateTime updated;


    @OneToMany(mappedBy = "hotel", cascade = CascadeType.ALL)
    private List<Room> rooms;

    public Hotel(int hotelId, String name, String street, String city, int zip, String country, LocalDateTime created, LocalDateTime updated, List<Room> rooms) {
        this.hotelId = hotelId;
        this.name = name;
        this.street = street;
        this.city = city;
        this.zip = zip;
        this.country = country;
        this.created = created;
        this.updated = updated;
        this.rooms = rooms;
    }
}


