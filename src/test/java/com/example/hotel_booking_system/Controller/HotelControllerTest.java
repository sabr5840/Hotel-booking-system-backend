package com.example.hotel_booking_system.Controller;

import com.example.hotel_booking_system.DTO.HotelDTO;
import com.example.hotel_booking_system.Enum.RoomType;
import com.example.hotel_booking_system.Model.Hotel;
import com.example.hotel_booking_system.Model.Room;
import com.example.hotel_booking_system.Service.HotelService;
import com.example.hotel_booking_system.Service.RoomService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import java.util.ArrayList;
import java.util.List;


import java.time.LocalDateTime;

import static org.mockito.Mockito.*;

class HotelControllerTest {


    @InjectMocks
    private HotelController hotelController;

    @Mock
    private HotelService hotelService;

    @Mock
    private RoomService roomService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    /*
    @Test
    public void testAddHotel() {
        Hotel hotel = new Hotel(); // Create a sample hotel object

        when(hotelService.createHotel(hotel)).thenReturn(hotel);

        ResponseEntity<Hotel> response = (ResponseEntity<Hotel>) hotelController.addHotel(hotel);

        verify(hotelService, times(1)).createHotel(hotel);
        assert(response.getStatusCode() == HttpStatus.CREATED);
        assert(response.getBody() == hotel);
    }

     */


    @Test
    public void testGetAllHotels() {
        int page = 0;
        int size = 10;

        // Create a list of sample HotelDTO objects
        List<HotelDTO> hotelDTOList = new ArrayList<>();

        // Add sample data to the list
        HotelDTO hotel1 = new HotelDTO(1, "Hotel A", "Street A", "City A", 12345, 1, "Country A");
        HotelDTO hotel2 = new HotelDTO(2, "Hotel B", "Street B", "City B", 54321, 2, "Country B");
        hotelDTOList.add(hotel1);
        hotelDTOList.add(hotel2);

        Page<HotelDTO> pageResponse = new PageImpl<>(hotelDTOList);

        when(hotelService.findAllHotels(PageRequest.of(page, size))).thenReturn(pageResponse);

        ResponseEntity<Page<HotelDTO>> response = hotelController.getAllHotels(page, size);

        verify(hotelService, times(1)).findAllHotels(PageRequest.of(page, size));
        assert(response.getStatusCode() == HttpStatus.OK);
        assert(response.getBody() == pageResponse);
    }

    @Test
    public void testGetHotelById() {
        int hotelId = 1;

        // Create a sample Hotel object
        Hotel hotel = new Hotel();
        hotel.setId(hotelId);

        when(hotelService.findHotelById(hotelId)).thenReturn(hotel);

        ResponseEntity<Hotel> response = hotelController.getHotelById(hotelId);

        verify(hotelService, times(1)).findHotelById(hotelId);
        assert(response.getStatusCode() == HttpStatus.OK);
        assert(response.getBody() == hotel);
    }

    @Test
    public void testUpdateHotel() {
        int hotelId = 1;
        Hotel updatedHotel = new Hotel();
        updatedHotel.setId(hotelId);
        updatedHotel.setHotelName("Updated Hotel Name");
        // Set other updated properties of the hotel as needed

        when(hotelService.updateHotel(hotelId, updatedHotel)).thenReturn(updatedHotel);

        ResponseEntity<Hotel> response = hotelController.updateHotel(hotelId, updatedHotel);

        verify(hotelService, times(1)).updateHotel(hotelId, updatedHotel);
        assert(response.getStatusCode() == HttpStatus.OK);
        assert(response.getBody() == updatedHotel);
    }



    @Test
    public void testDeleteHotel() {
        int hotelId = 1;

        // Assume that the delete operation is successful
        doNothing().when(hotelService).deleteHotel(hotelId);

        ResponseEntity<HttpStatus> response = hotelController.deleteHotel(hotelId);

        verify(hotelService, times(1)).deleteHotel(hotelId);
        assert(response.getStatusCode() == HttpStatus.NO_CONTENT);
    }

    /*

    @Test
    public void testAddRoomToHotel() {
        int hotelId = 1;

        // Opret sample data
        Hotel sampleHotel = new Hotel(1, "Sample Hotel", "Sample Street", "Sample City", 12345, 1, "Sample Country");
        Room sampleRoom = new Room(1, 101, 2, 1, RoomType.DOUBLE, 150, LocalDateTime.now(), LocalDateTime.now(), sampleHotel, new ArrayList<>());

        // Brug sampleRoom til at simulere tilføjelsen af værelset til hotellet
        when(roomService.addRoomToHotel(hotelId, sampleRoom)).thenReturn(sampleRoom);

        ResponseEntity<Room> response = hotelController.addRoomToHotel(hotelId, sampleRoom);

        verify(roomService, times(1)).addRoomToHotel(hotelId, sampleRoom);
        assert(response.getStatusCode() == HttpStatus.CREATED);
        assert(response.getBody() == sampleRoom);
    }

     */
}