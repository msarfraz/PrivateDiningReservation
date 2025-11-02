package com.reservation.dining.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;
import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@Entity
public class Room {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    //private Long restaurantId;
    private String name;
    @Enumerated(EnumType.STRING)
    private RoomType roomType;
    private int minCapacity;
    private int maxCapacity;
    private int minSpend;

    @ManyToOne
    @JoinColumn(name = "restaurantId", referencedColumnName = "id")
    private Restaurant restaurant;

}
