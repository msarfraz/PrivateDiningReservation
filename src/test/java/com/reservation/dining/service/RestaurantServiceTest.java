package com.reservation.dining.service;

import com.reservation.dining.dto.RestaurantDTO;
import com.reservation.dining.dto.SearchParams;
import com.reservation.dining.dto.SearchResult;
import com.reservation.dining.repository.RestaurantRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Date;
import java.util.List;

import static org.mockito.ArgumentMatchers.*;
@ExtendWith(MockitoExtension.class)
public class RestaurantServiceTest {

    @InjectMocks
    RestaurantServiceImpl restaurantService;

    @Mock
    RestaurantRepository restaurantRepository;

    SearchResult searchResult;
    @BeforeEach
    public void init(){
        searchResult = new SearchResult(1l, "Restaurant 1", "Room 1", 1l, "Hall", 1, 5, 100);
     }

    @Test
    public void searchRestaurants_success(){
        Mockito.when(restaurantRepository.findWithinDistance(anyDouble(), anyDouble(),anyDouble(), any(), anyInt())).thenReturn(List.of(searchResult));

        List<RestaurantDTO> restaurants = restaurantService.getRestaurants(new SearchParams(1d,1d, new Date(), 5, 1d));
        Assertions.assertEquals(1, restaurants.size());
    }
    @Test
    public void searchRestaurants_nodata(){
        Mockito.when(restaurantRepository.findWithinDistance(anyDouble(), anyDouble(),anyDouble(), any(), anyInt())).thenReturn(List.of());

        List<RestaurantDTO> restaurants = restaurantService.getRestaurants(new SearchParams(1d,1d, new Date(), 5, 1d));
        Assertions.assertEquals(0, restaurants.size());
    }
}
