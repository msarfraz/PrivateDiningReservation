package com.reservation.dining.web;

import com.reservation.dining.api.ReservationAPI;
import com.reservation.dining.config.ReservationResponse;
import com.reservation.dining.config.ReservationsResponse;
import com.reservation.dining.config.TableEventPublisher;
import com.reservation.dining.dto.ReservationDTO;
import com.reservation.dining.config.Response;
import com.reservation.dining.service.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ReservationController implements ReservationAPI {
    @Autowired
    ReservationService reservationService;
    @Autowired
    private TableEventPublisher tableEventPublisher;
    @Override
    public ResponseEntity<ReservationResponse> createReservation(ReservationDTO reservation) {
        try{
            reservation.validate(); // dummy validation
            ReservationDTO newReservation = reservationService.createReservation(reservation);
            if(newReservation == null){
                return ResponseEntity.status(HttpStatus.CONFLICT).body(new ReservationResponse("Spot is already booked"));
            }
            tableEventPublisher.publishTableReservedEvent("Reservation " + newReservation.getReservationId() + " booked in " + newReservation.getRestaurantName());
            return ResponseEntity.status(HttpStatus.CREATED).body(new ReservationResponse(newReservation));
        }catch(IllegalArgumentException ex){
            return ResponseEntity.badRequest().body(new ReservationResponse(ex.getMessage()));
        }

    }

    @Override
    public ResponseEntity<ReservationsResponse> getUserReservations(String userId) {
        List<ReservationDTO> reservations = reservationService.getReservationsByDiner(userId);
        return ResponseEntity.ok(new ReservationsResponse( reservations));
    }

    @Override
    public ResponseEntity<ReservationsResponse> getRestaurantReservations(Long restaurantId) {
        List<ReservationDTO> reservations = reservationService.getReservationsByRestaurant(restaurantId);
        return ResponseEntity.ok(new ReservationsResponse(reservations));
    }

    @Override
    public ResponseEntity cancelReservation(Long id) {
        reservationService.deleteReservation(id);
        tableEventPublisher.publishTableReservedEvent("Reservation " + id + " cancelled");
        return ResponseEntity.noContent().build();
    }
}
