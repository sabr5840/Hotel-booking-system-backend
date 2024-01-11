package com.example.hotel_booking_system.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;


@Getter
@Setter
@Entity
@NoArgsConstructor
public class Guest {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int guestId;

    private String username;
    private String firstname;
    private String lastName;
    private String email;
    private int phoneNumber;

    private LocalDateTime created;
    private LocalDateTime updated;

    public Guest(int guestId, String username, String firstname, String lastName, String email, int phoneNumber, LocalDateTime created, LocalDateTime updated) {
        this.guestId = guestId;
        this.username = username;
        this.firstname = firstname;
        this.lastName = lastName;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.created = created;
        this.updated = updated;
    }


}
