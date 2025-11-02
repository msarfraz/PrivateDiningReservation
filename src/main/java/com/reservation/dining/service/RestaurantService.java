package com.reservation.dining.service;

import com.reservation.dining.dto.RestaurantDTO;
import com.reservation.dining.dto.SearchParams;
import com.reservation.dining.model.Restaurant;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

public interface RestaurantService {
    public List<RestaurantDTO> getRestaurants(SearchParams searchParams);
}
