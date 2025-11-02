package com.reservation.dining.dto;

import com.reservation.dining.model.RoomType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class SearchResult {
    private Long id;
    private String name;
    private String roomName;
    private Long roomId;
    private String roomType;
    private int minCapacity;
    private int maxCapacity;
    private int minSpend;
}
