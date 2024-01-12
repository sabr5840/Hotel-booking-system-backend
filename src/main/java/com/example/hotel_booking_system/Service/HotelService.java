package com.example.hotel_booking_system.Service;

import com.example.hotel_booking_system.DTO.HotelDTO;
import com.example.hotel_booking_system.Model.Hotel;
import com.example.hotel_booking_system.Repository.HotelRepo;
import org.apache.velocity.exception.ResourceNotFoundException;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class HotelService {

    private final ModelMapper modelMapper;
    private HotelRepo hotelRepo;

    @Autowired
    public HotelService(HotelRepo hotelRepo, ModelMapper modelMapper) {
        this.hotelRepo = hotelRepo;
        this.modelMapper = modelMapper;
    }

    public Hotel createHotel(Hotel hotel) {
        hotel.setCreated(LocalDateTime.now());
        hotel.setUpdated(LocalDateTime.now());
        return hotelRepo.save(hotel);
    }

    public Page<HotelDTO> findAllHotels(Pageable pageable) {
        return hotelRepo.findAll(pageable)
                .map(hotel -> modelMapper.map(hotel, HotelDTO.class));
    }

    public Hotel findHotelById(int id) {
        return hotelRepo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Hotel not found with id: " + id));
    }

    public Hotel updateHotel(int id, Hotel hotelDetails) {
        Hotel hotel = hotelRepo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Hotel not found with id: " + id));

        hotel.setHotelName(hotelDetails.getHotelName());
        hotel.setStreet(hotelDetails.getStreet());
        hotel.setCity(hotelDetails.getCity());
        hotel.setZip(hotelDetails.getZip());
        hotel.setBuildingNumber(hotelDetails.getBuildingNumber());
        hotel.setCountry(hotelDetails.getCountry());
        hotel.setUpdated(LocalDateTime.now());

        return hotelRepo.save(hotel);
    }

    public void deleteHotel(int id) {
        hotelRepo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Hotel not found with id: " + id));
        hotelRepo.deleteById(id);
    }

    public List<Hotel> searchHotels(String hotelName, int id, String country, String city) {
        // retrieve all hotels
        List<Hotel> hotels = hotelRepo.findAll();

        //filter based on the passed parameters
        if (hotelName != null) {
            hotels = hotels.stream().filter(hotel -> hotel.getHotelName().equalsIgnoreCase(hotelName)).collect(Collectors.toList());
        }
        if (id != 0) {
            hotels = hotels.stream().filter(hotel -> hotel.getId() == id).collect(Collectors.toList());
        }
        if (country != null) {
            hotels = hotels.stream().filter(hotel -> hotel.getCountry().equalsIgnoreCase(country)).collect(Collectors.toList());
        }
        if (city != null) {
            hotels = hotels.stream().filter(hotel -> hotel.getCity().equalsIgnoreCase(city)).collect(Collectors.toList());
        }

        return hotels;
    }


}
