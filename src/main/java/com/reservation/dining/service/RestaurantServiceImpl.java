package com.reservation.dining.service;

import com.reservation.dining.dto.RestaurantDTO;
import com.reservation.dining.dto.RoomDTO;
import com.reservation.dining.dto.SearchParams;
import com.reservation.dining.dto.SearchResult;
import com.reservation.dining.model.Restaurant;
import com.reservation.dining.model.RoomType;
import com.reservation.dining.repository.RestaurantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.locationtech.jts.geom.Point;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class RestaurantServiceImpl implements RestaurantService{
    @Autowired
    RestaurantRepository restaurantRepository;

    @Override
    public List<RestaurantDTO> getRestaurants(SearchParams searchParams) {
        List<SearchResult> searchResults = restaurantRepository.findWithinDistance(searchParams.getLongitude(), searchParams.getLatitude(), searchParams.getSearchDistance(), searchParams.getRequestedTime(), searchParams.getPartySize());
        List<RestaurantDTO> restaurants = new ArrayList<>();
        HashMap<Long, RestaurantDTO> restaurantsMap = new HashMap<>();
        for (SearchResult searchResult: searchResults){
            if(restaurantsMap.containsKey(searchResult.getId())) {
                addRoom(restaurantsMap.get(searchResult.getId()), searchResult);
            }
            else {
                RestaurantDTO restaurantDTO = new RestaurantDTO(searchResult.getId(), searchResult.getName(), new ArrayList<>());
                addRoom(restaurantDTO, searchResult);
                restaurantsMap.put(searchResult.getId(), restaurantDTO);
            }
        }
        return restaurantsMap.values().stream().collect(Collectors.toList());
    }

    private void addRoom(RestaurantDTO restaurantDTO, SearchResult searchResult){
        restaurantDTO.getRooms().add(new RoomDTO(
                searchResult.getRoomId(),
                searchResult.getRoomName(),
                RoomType.valueOf(searchResult.getRoomType()),
                searchResult.getMinCapacity(),
                searchResult.getMaxCapacity(),
                searchResult.getMinSpend()
        ));
    }
}
