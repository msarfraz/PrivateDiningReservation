package com.reservation.dining.dto;

import com.reservation.dining.model.RoomType;
import lombok.*;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class RoomDTO {
    private Long id;
    private String name;
    private RoomType roomType;
    private int minCapacity;
    private int maxCapacity;
    private int minSpend;
}
