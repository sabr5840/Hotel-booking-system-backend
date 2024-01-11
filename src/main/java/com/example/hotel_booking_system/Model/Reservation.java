package com.example.hotel_booking_system.Model;

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
    private int reservationId;

    private LocalDate reservationStart;
    private LocalDate reservationEnd;

    //The price at the time of the reservation
    private int price;

    private LocalDateTime created;
    private LocalDateTime updated;

    @ManyToOne
    private Guest guest;

    @ManyToOne
    private Room room;

    public Reservation(int reservationId, LocalDate reservationStart, LocalDate reservationEnd, LocalDateTime created, LocalDateTime updated, Guest guest, Room room) {
        this.reservationId = reservationId;
        this.reservationStart = reservationStart;
        this.reservationEnd = reservationEnd;
        this.created = created;
        this.updated = updated;
        this.guest = guest;
        this.room = room;
    }


}

