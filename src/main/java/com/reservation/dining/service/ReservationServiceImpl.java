package com.reservation.dining.service;

import com.reservation.dining.dto.ReservationDTO;
import com.reservation.dining.dto.RestaurantDTO;
import com.reservation.dining.model.Reservation;
import com.reservation.dining.model.Restaurant;
import com.reservation.dining.model.Room;
import com.reservation.dining.repository.ReservationRepository;
import com.reservation.dining.repository.RestaurantRepository;
import com.reservation.dining.repository.RoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ReservationServiceImpl implements ReservationService{
    @Autowired
    ReservationRepository reservationRepository;

    @Autowired
    RestaurantRepository restaurantRepository;

    @Autowired
    RoomRepository roomRepository;

    @Override
    public ReservationDTO createReservation(ReservationDTO reservation) {
        Optional<Restaurant> restaurant = restaurantRepository.findById(reservation.getRestaurantId());
        Optional<Room> room = roomRepository.findById(reservation.getRoomId());
        if(restaurant.isPresent() && room.isPresent() && room.get().getRestaurant().getId().equals(restaurant.get().getId())){
            Long reservationId = reservationRepository.createReservation(room.get().getRestaurant().getId(), room.get().getId(), reservation.getUserId(),
                    reservation.getBookingStartTime(), reservation.getBookingEndTime(), reservation.getPersons());
            if(reservationId != null && reservationId > 0){
                Reservation newReservation = reservationRepository.findById(reservationId).get();
                return new ReservationDTO(newReservation);
            }
            return null;
        }
        else throw new IllegalArgumentException("Invalid Data: Restaurant or Room id is invalid");


    }

    @Override
    public List<ReservationDTO> getReservationsByDiner(String userId) {
        return reservationRepository.findAllByUserId(userId).stream().map(reservation -> new ReservationDTO(reservation))
                .collect(Collectors.toList());
    }

    @Override
    public List<ReservationDTO> getReservationsByRestaurant(Long restaurantId) {
        return reservationRepository.findAllByRestaurantId(restaurantId).stream().map(reservation -> new ReservationDTO(reservation))
                .collect(Collectors.toList());
    }

    @Override
    public void deleteReservation(Long reservationId) {
        reservationRepository.deleteById(reservationId);
    }
}
