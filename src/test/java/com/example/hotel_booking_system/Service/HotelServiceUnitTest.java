package com.example.hotel_booking_system.Service;

import com.example.hotel_booking_system.DTO.HotelDTO;
import com.example.hotel_booking_system.Model.Hotel;
import com.example.hotel_booking_system.Repository.HotelRepo;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.mockito.Mockito.*;

public class HotelServiceUnitTest {

    private HotelService hotelService;

    private HotelRepo hotelRepo;
    private ModelMapper modelMapper;

    @BeforeEach
    public void setUp() {
        hotelRepo = mock(HotelRepo.class);
        modelMapper = new ModelMapper();
        hotelService = new HotelService(hotelRepo, modelMapper);
    }

    @Test
    public void testCreateHotel() {
        Hotel hotel = new Hotel();
        hotel.setHotelName("Sample Hotel");
        // Set other properties of the hotel as needed

        when(hotelRepo.save(hotel)).thenReturn(hotel);

        Hotel createdHotel = hotelService.createHotel(hotel);

        verify(hotelRepo, times(1)).save(hotel);
        assert(createdHotel != null);
    }

    @Test
    public void testFindAllHotels() {
        Pageable pageable = Pageable.unpaged();

        List<Hotel> hotels = new ArrayList<>();
        Hotel hotel1 = new Hotel();
        hotel1.setId(1);
        hotel1.setHotelName("Hotel 1");
        // Set other properties of hotel1 as needed

        Hotel hotel2 = new Hotel();
        hotel2.setId(2);
        hotel2.setHotelName("Hotel 2");
        // Set other properties of hotel2 as needed

        hotels.add(hotel1);
        hotels.add(hotel2);

        Page<Hotel> pageResponse = new PageImpl<>(hotels);

        when(hotelRepo.findAll(pageable)).thenReturn(pageResponse);

        Page<HotelDTO> hotelDTOPage = hotelService.findAllHotels(pageable);

        verify(hotelRepo, times(1)).findAll(pageable);
        assert(hotelDTOPage.getTotalElements() == hotels.size());
    }

    @Test
    public void testFindHotelById() {
        int hotelId = 1;
        Hotel sampleHotel = new Hotel();
        sampleHotel.setId(hotelId);
        sampleHotel.setHotelName("Sample Hotel");
        // Set other properties of the sample hotel as needed

        when(hotelRepo.findById(hotelId)).thenReturn(Optional.of(sampleHotel));

        Hotel foundHotel = hotelService.findHotelById(hotelId);

        verify(hotelRepo, times(1)).findById(hotelId);
        assert(foundHotel != null);
        assert(foundHotel.getId() == hotelId);
    }

    @Test
    public void testUpdateHotel() {
        int hotelId = 1;
        Hotel hotelDetails = new Hotel();
        hotelDetails.setHotelName("Updated Hotel Name");
        // Set other updated properties of the hotelDetails as needed

        Hotel sampleHotel = new Hotel();
        sampleHotel.setId(hotelId);
        sampleHotel.setHotelName("Sample Hotel");
        // Set original properties of the sample hotel as needed

        when(hotelRepo.findById(hotelId)).thenReturn(Optional.of(sampleHotel));
        when(hotelRepo.save(sampleHotel)).thenReturn(sampleHotel);

        Hotel updatedHotel = hotelService.updateHotel(hotelId, hotelDetails);

        verify(hotelRepo, times(1)).findById(hotelId);
        verify(hotelRepo, times(1)).save(sampleHotel);
        assert(updatedHotel != null);
        assert(updatedHotel.getHotelName().equals("Updated Hotel Name"));
    }

    @Test
    public void testDeleteHotel() {
        int hotelId = 1;
        Hotel sampleHotel = new Hotel();
        sampleHotel.setId(hotelId);
        sampleHotel.setHotelName("Sample Hotel");
        // Set other properties of the sample hotel as needed

        when(hotelRepo.findById(hotelId)).thenReturn(Optional.of(sampleHotel));

        hotelService.deleteHotel(hotelId);

        verify(hotelRepo, times(1)).findById(hotelId);
        verify(hotelRepo, times(1)).deleteById(hotelId);
    }

    // Add other test methods for HotelService as needed
}
