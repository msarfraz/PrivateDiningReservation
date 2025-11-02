package com.reservation.dining.config;

import com.reservation.dining.dto.ReservationDTO;

public class ReservationResponse extends Response<ReservationDTO> {
    public ReservationResponse(ReservationDTO data){
        super(data);
    }
    public ReservationResponse(String message){
        super(message);
    }
}
