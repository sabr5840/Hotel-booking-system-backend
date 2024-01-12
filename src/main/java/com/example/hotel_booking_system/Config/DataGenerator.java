package com.example.hotel_booking_system.Config;

import com.example.hotel_booking_system.Enum.RoomType;
import com.example.hotel_booking_system.Model.Hotel;
import com.example.hotel_booking_system.Model.Room;
import com.example.hotel_booking_system.Repository.GuestRepo;
import com.example.hotel_booking_system.Repository.HotelRepo;
import com.example.hotel_booking_system.Repository.ReservationRepo;
import com.example.hotel_booking_system.Repository.RoomRepo;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Component
public class DataGenerator implements CommandLineRunner {

    GuestRepo guestRepo;
    HotelRepo hotelRepo;
    ReservationRepo reservationRepo;
    RoomRepo roomRepo;

    public DataGenerator(GuestRepo guestRepo, HotelRepo hotelRepo, ReservationRepo reservationRepo, RoomRepo roomRepo) {
        this.guestRepo = guestRepo;
        this.hotelRepo = hotelRepo;
        this.reservationRepo = reservationRepo;
        this.roomRepo = roomRepo;
    }

    String[] prefixesHotelName = {"Royal", "Grand", "Pearl", "Emerald", "Sunset", "Riverside", "Mountain", "Golden", "Silver", "Crystal", "Ocean", "Garden", "Sky", "Star", "Moonlight"};
    String[] suffixesHotelName = {"Inn", "Hotel", "Lodge", "Resort", "Villa", "Place", "Palace", "Mansion", "Retreat", "Bungalow", "Hostel", "Suite", "Hideaway", "Haven", "Castle"};

    String[] streetNames = {"Maple", "Oak", "Pine", "Elm", "Cedar", "Birch", "Willow", "Aspen", "Holly", "Juniper", "Magnolia", "Walnut", "Spruce", "Chestnut", "Poplar"};
    String[] cityNames = {"Springfield", "Rivertown", "Greenville", "Fairview", "Lakewood", "Sunnydale", "Hillcrest", "Rockville", "Meadowbrook", "Westwood", "Kingsport", "Brookdale", "Harborview", "Clearwater", "Rosewood"};
    String[] countryNames = {"Freedonia", "Atlantis", "Ruritania", "Eldorado", "Ivalice", "Narnia", "Gondor", "Asgard", "Wakanda", "Zembla", "Genovia", "Latveria", "Pandora", "Kyrat", "Arstotzka"};

    RoomType[] roomTypes = RoomType.values();

    @Override
    public void run(String... args) throws Exception {

        //Random class provides different methods to generate random numbers of different data types
        Random random = new Random();

        //Number of hotels in each batch (Ensuring better performance using batch operations) - 25 hotels generated in one batch
        int batchSize = 10;

        //loop runs 250 times to create 250 hotels.
        for (int i = 0; i < 250; i += batchSize) {

            List<Hotel> hotelsBatch = new ArrayList<>();
            List<Room> roomsBatch = new ArrayList<>();

            //generate hotel name
            String hotelName = prefixesHotelName[random.nextInt(prefixesHotelName.length)] + " " +  suffixesHotelName[random.nextInt(suffixesHotelName.length)] + " " + (i + 1);

            //generate address components
            String street = streetNames[random.nextInt(streetNames.length)] + " Street " + (random.nextInt(100) + 1);
            String city = cityNames[random.nextInt(cityNames.length)];
            String country = countryNames[random.nextInt(countryNames.length)];

            Hotel hotel = new Hotel();
            hotel.setHotelName(hotelName);
            hotel.setStreet(street);
            hotel.setBuildingNumber(5 + random.nextInt(3000)); //building number range
            hotel.setCity(city);
            hotel.setZip(10000 + random.nextInt(90000)); //zip code range 10000-80000
            hotel.setCountry(country);
            hotel.setCreated(LocalDateTime.now());
            hotel.setUpdated(LocalDateTime.now());

            List<Room> rooms = new ArrayList<>();
            int numberOfRooms = 10 + random.nextInt(31); //room range 10-40

            for (int j = 0; j < numberOfRooms; j++) {

                // Create new room
                Room room = new Room();
                room.setRoomNumber(j);
                room.setNumberOfBeds(1 + random.nextInt(4)); //number of bed range 1-4
                room.setFloor(1 + random.nextInt(8));
                room.setRoomType(roomTypes[random.nextInt(roomTypes.length)]);
                room.setPricePerNight(500 + random.nextInt(1501)); //price range 500-2000 euro pr night
                room.setCreated(LocalDateTime.now());
                room.setUpdated(LocalDateTime.now());
                room.setHotel(hotel);

                rooms.add(room);
            }

            hotelsBatch.add(hotel);
            roomsBatch.addAll(rooms);

            // Save hotel and its rooms in the database
            hotelRepo.saveAll(hotelsBatch);
            roomRepo.saveAll(roomsBatch);

        }

    }


}
