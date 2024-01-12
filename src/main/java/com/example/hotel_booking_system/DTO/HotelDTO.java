package com.example.hotel_booking_system.DTO;

import java.time.LocalDateTime;

public class HotelDTO {

    private int id;
    private String hotelName;
    private String street;
    private String city;
    private int zip;
    private int buildingNumber;
    private String country;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getHotelName() {
        return hotelName;
    }

    public void setHotelName(String hotelName) {
        this.hotelName = hotelName;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public int getZip() {
        return zip;
    }

    public void setZip(int zip) {
        this.zip = zip;
    }

    public int getBuildingNumber() {
        return buildingNumber;
    }

    public void setBuildingNumber(int buildingNumber) {
        this.buildingNumber = buildingNumber;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    // Parameterized constructor
    public HotelDTO(int id, String hotelName, String street, String city, int zip, int buildingNumber, String country) {
        this.id = id;
        this.hotelName = hotelName;
        this.street = street;
        this.city = city;
        this.zip = zip;
        this.buildingNumber = buildingNumber;
        this.country = country;
    }

    // No-argument constructor
    public HotelDTO() {
        // This constructor is intentionally empty and can be used by frameworks
        // that require a no-argument constructor
    }

}
