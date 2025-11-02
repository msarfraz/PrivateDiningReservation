package com.reservation.dining.web;

import com.reservation.dining.api.RestaurantAPI;
import com.reservation.dining.config.RestaurantResponse;
import com.reservation.dining.dto.RestaurantDTO;
import com.reservation.dining.dto.SearchParams;
import com.reservation.dining.model.Restaurant;
import com.reservation.dining.service.RestaurantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;


@RestController
public class RestaurantController implements RestaurantAPI {
    @Autowired
    RestaurantService restaurantService;

    @Override
    public ResponseEntity<RestaurantResponse> searchRestaurants(SearchParams searchParams){
        searchParams.validate(); // dummy validation
        List<RestaurantDTO> restaurants = restaurantService.getRestaurants(searchParams);
        return ResponseEntity.ok(new RestaurantResponse(restaurants)) ;
    }
}
