package com.reservation.dining.dto;

import com.reservation.dining.model.Restaurant;
import lombok.*;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class RestaurantDTO {
    private Long id;
    private String name;
    private List<RoomDTO> rooms;

    public RestaurantDTO(Restaurant restaurant){
        this.id = restaurant.getId();
        this.name = restaurant.getName();
    }
}
