package com.reservation.dining.service;

import com.reservation.dining.dto.ReservationDTO;
import com.reservation.dining.model.Reservation;

import java.util.List;


public interface ReservationService {
    public ReservationDTO createReservation(ReservationDTO reservation);
    public List<ReservationDTO> getReservationsByDiner(String userId);
    public List<ReservationDTO> getReservationsByRestaurant(Long restaurantId);
    public void deleteReservation(Long reservationId);
}
