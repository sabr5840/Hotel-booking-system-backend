package com.example.hotel_booking_system.Controller;

import com.example.hotel_booking_system.DTO.HotelDTO;
import com.example.hotel_booking_system.Model.Hotel;
        import com.example.hotel_booking_system.Service.HotelService;
        import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
        import org.springframework.http.ResponseEntity;
        import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

@RestController
@CrossOrigin (origins = "http://localhost:63342") // allow CORS from localhost on port 63342
@RequestMapping("/hotels")
public class HotelController {

    private HotelService hotelService;

    @Autowired
    public HotelController(HotelService hotelService) {
        this.hotelService = hotelService;
    }

    @PostMapping("/create")
    public ResponseEntity<Hotel> addHotel(@RequestBody Hotel hotel) {
        Hotel newHotel = hotelService.createHotel(hotel);
        return new ResponseEntity<>(newHotel, HttpStatus.CREATED);
    }

    @GetMapping("/all")
    public ResponseEntity<Page<HotelDTO>> getAllHotels(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size) {
        Pageable pageable = PageRequest.of(page, size);
        Page<HotelDTO> hotels = hotelService.findAllHotels(pageable);
        return new ResponseEntity<>(hotels, HttpStatus.OK);
    }


    @GetMapping("/find/{id}")
    public ResponseEntity<Hotel> getHotelById(@PathVariable int id) {
        Hotel hotel = hotelService.findHotelById(id);
        return new ResponseEntity<>(hotel, HttpStatus.OK);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Hotel> updateHotel(@PathVariable int id, @RequestBody Hotel hotelDetails) {
        Hotel updatedHotel = hotelService.updateHotel(id, hotelDetails);
        return new ResponseEntity<>(updatedHotel, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<HttpStatus> deleteHotel(@PathVariable int id) {
        hotelService.deleteHotel(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping("/search")
    public ResponseEntity<List<Hotel>> searchHotels(@RequestParam(required = false) String hotelName,
                                                    @RequestParam(required = false) int id,
                                                    @RequestParam(required = false) String country,
                                                    @RequestParam(required = false) String city) {
        List<Hotel> hotels = hotelService.searchHotels(hotelName, id, country, city);
        return new ResponseEntity<>(hotels, HttpStatus.OK);
    }



}
