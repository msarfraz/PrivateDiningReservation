package com.reservation.dining.config;

import com.reservation.dining.dto.ReservationDTO;

import java.util.List;

public class ReservationsResponse extends Response<List<ReservationDTO>> {
    public ReservationsResponse(List<ReservationDTO> data){
        super(data);
    }
    public ReservationsResponse(String message){
        super(message);
    }
}
