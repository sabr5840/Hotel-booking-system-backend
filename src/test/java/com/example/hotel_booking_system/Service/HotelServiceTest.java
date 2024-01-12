package com.example.hotel_booking_system.Service;
import com.example.hotel_booking_system.Model.Hotel;
import com.example.hotel_booking_system.Repository.HotelRepo;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class HotelServiceTest {

    @Mock
    private HotelRepo hotelRepo;

    @InjectMocks
    private HotelService hotelService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testAddHotel() {
        // Arrange
        Hotel hotel = new Hotel();
        hotel.setHotelName("Test Hotel");
        hotel.setStreet("Test Street");
        hotel.setCity("Test City");
        hotel.setZip(12345);
        hotel.setBuildingNumber(1);
        hotel.setCountry("Test Country");

        when(hotelRepo.save(hotel)).thenReturn(hotel);

        // Act
        Hotel savedHotel = hotelService.createHotel(hotel);

        // Assert
        assertNotNull(savedHotel.getCreated());
        assertNotNull(savedHotel.getUpdated());
        assertEquals("Test Hotel", savedHotel.getHotelName());
        verify(hotelRepo).save(hotel); // Verifies that save was called with the specific hotel object

    }



}