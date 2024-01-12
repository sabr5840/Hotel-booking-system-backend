package com.example.hotel_booking_system.Model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
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
    private int id;

    private String hotelName;
    private String street;
    private String city;
    private int zip;
    private int buildingNumber;
    private String country;
    private LocalDateTime created;
    private LocalDateTime updated;


    @OneToMany(mappedBy = "hotel", cascade = CascadeType.ALL)
    @JsonManagedReference

    private List<Room> rooms;

    public Hotel(int id, String hotelName, String street, String city, int zip, int buildingNumber, String country, LocalDateTime created, LocalDateTime updated, List<Room> rooms) {
        this.id = id;
        this.hotelName = hotelName;
        this.street = street;
        this.city = city;
        this.zip = zip;
        this.buildingNumber = buildingNumber;
        this.country = country;
        this.created = created;
        this.updated = updated;
        this.rooms = rooms;
    }
}


