package com.example.hotel_booking_system.Model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@Setter
@Entity
@NoArgsConstructor
public class Reservation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private LocalDate reservationStart;
    private LocalDate reservationEnd;

    //The price at the time of the reservation
    private int price;

    private LocalDateTime created;
    private LocalDateTime updated;

    @ManyToOne
    @JsonManagedReference
    private Guest guest;

    @ManyToOne
    @JsonManagedReference
    private Room room;

    public Reservation(int id, LocalDate reservationStart, LocalDate reservationEnd, LocalDateTime created, LocalDateTime updated, Guest guest, Room room) {
        this.id = id;
        this.reservationStart = reservationStart;
        this.reservationEnd = reservationEnd;
        this.created = created;
        this.updated = updated;
        this.guest = guest;
        this.room = room;
    }


}

