package com.reservation.dining.config;

import com.reservation.dining.dto.ReservationDTO;
import com.reservation.dining.dto.RestaurantDTO;
import com.reservation.dining.dto.SearchResult;
import com.reservation.dining.model.Restaurant;

import java.util.List;

public class RestaurantResponse extends Response<List<RestaurantDTO>> {
    public RestaurantResponse(List<RestaurantDTO> data){
        super(data);
    }
    public RestaurantResponse(String message){
        super(message);
    }
}
