package com.reservation.dining.service;

import com.reservation.dining.dto.ReservationDTO;
import com.reservation.dining.model.Reservation;
import com.reservation.dining.model.Restaurant;
import com.reservation.dining.model.Room;
import com.reservation.dining.model.RoomType;
import com.reservation.dining.repository.ReservationRepository;
import com.reservation.dining.repository.RestaurantRepository;
import com.reservation.dining.repository.RoomRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.locationtech.jts.geom.Point;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class ReservationServiceTest {
    @InjectMocks
    ReservationServiceImpl reservationService;

    @Mock
    ReservationRepository reservationRepository;

    @Mock
    RestaurantRepository restaurantRepository;
    @Mock
    RoomRepository roomRepository;
    Restaurant restaurant;
    Reservation reservation;
    ReservationDTO input;

    Room room;
    @BeforeEach
    public void init(){
        restaurant = new Restaurant(1l, "Restaurant 1", null);
        room = new Room(1l, "Room 1", RoomType.PrivateRoom, 1, 1, 1, restaurant);
        reservation = new Reservation(1l, "msarfraz", new Date(), new Date(), 3, restaurant, room);

        input = new ReservationDTO();
        input.setRestaurantId(1);
        input.setRoomId(1);
        input.setUserId("msarfraz");
        input.setBookingStartTime(new Date());
        input.setBookingEndTime(new Date());
        input.setPersons(5);

        Mockito.lenient().when(restaurantRepository.findById(eq(1l))).thenReturn(Optional.of(restaurant));
        Mockito.lenient().when(roomRepository.findById(eq(1l))).thenReturn(Optional.of(room));
        Mockito.lenient().when(reservationRepository.findById(eq(1l))).thenReturn(Optional.of(reservation));
    }

    @Test
    public void createReservationTest_success(){
        Mockito.when(reservationRepository.createReservation(any(), any(),any(),any(),any(),eq(5))).thenReturn(1l);

        ReservationDTO result = reservationService.createReservation(input);

        Assertions.assertEquals(1, result.getReservationId());
    }
    @Test
    public void createReservationTest_failed(){
        Mockito.when(roomRepository.findById(eq(2l))).thenReturn(Optional.empty());
        input.setRoomId(2);

        IllegalArgumentException exception = Assertions.assertThrows(IllegalArgumentException.class, () -> {
            // This is the code that will throw the exception
            reservationService.createReservation(input);
        }, "Invalid Data: Restaurant or Room id is invalid");

    }
    @Test
    public void createReservationTest_concurrent_failed(){
        Mockito.when(reservationRepository.createReservation(any(), any(),any(),any(),any(),eq(5))).thenReturn(0l);

        ReservationDTO reservationDTO = reservationService.createReservation(input);
        Assertions.assertEquals(null, reservationDTO);
    }

    @Test
    public void getReservationsByDiner_success(){
        Mockito.when(reservationRepository.findAllByUserId(eq("msarfraz"))).thenReturn(List.of(reservation));

        List<ReservationDTO> reservationDTOList = reservationService.getReservationsByDiner("msarfraz");
        Assertions.assertEquals(1, reservationDTOList.size());
    }
    @Test
    public void getReservationsByDiner_failed(){
        Mockito.when(reservationRepository.findAllByUserId(eq("msarfraz"))).thenReturn(List.of());

        List<ReservationDTO> reservationDTOList = reservationService.getReservationsByDiner("msarfraz");
        Assertions.assertEquals(0, reservationDTOList.size());
    }

    @Test
    public void getReservationsByRestaurant_success(){
        Mockito.when(reservationRepository.findAllByRestaurantId(eq(1l))).thenReturn(List.of(reservation));

        List<ReservationDTO> reservationDTOList = reservationService.getReservationsByRestaurant(1l);
        Assertions.assertEquals(1, reservationDTOList.size());
    }

    @Test
    public void getReservationsByRestaurant_failed(){
        Mockito.when(reservationRepository.findAllByRestaurantId(eq(1l))).thenReturn(List.of());

        List<ReservationDTO> reservationDTOList = reservationService.getReservationsByRestaurant(1l);
        Assertions.assertEquals(0, reservationDTOList.size());
    }
    @Test
    public void deleteReservation_success(){
        reservationService.deleteReservation(1l);

        verify(reservationRepository, times(1)).deleteById(1l);
    }
}
