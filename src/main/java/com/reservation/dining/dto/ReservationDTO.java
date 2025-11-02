package com.reservation.dining.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.reservation.dining.model.Reservation;
import com.reservation.dining.model.RoomType;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.*;
import io.swagger.v3.oas.annotations.media.Schema;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class ReservationDTO {
    private long reservationId;
    private long restaurantId;
    private long roomId;
    private String userId;
    @Schema(description = "Reservation start time", example = "2025-11-15T18:00:00")
    @JsonFormat(shape = JsonFormat.Shape.STRING,pattern = "yyyy-MM-dd'T'HH:mm:ss")

    private Date bookingStartTime;
    @Schema(description = "Reservation start time", example = "2025-11-15T18:30:00")
    @JsonFormat(shape = JsonFormat.Shape.STRING,pattern = "yyyy-MM-dd'T'HH:mm:ss")
    private Date bookingEndTime;
    private int persons;


    private String restaurantName;
    private String roomName;
    @Enumerated(EnumType.STRING)
    private RoomType roomType;
    private int minCapacity;
    private int maxCapacity;
    private int minSpend;

    public ReservationDTO(Reservation reservation){
        this.reservationId = reservation.getId();
        this.restaurantId = reservation.getRestaurant().getId();
        this.roomId = reservation.getRoom().getId();
        this.userId = reservation.getUserId();
        this.bookingStartTime = reservation.getBookingStartTime();
        this.bookingEndTime = reservation.getBookingEndTime();
        this.persons = reservation.getPersons();
        this.restaurantName = reservation.getRestaurant().getName();
        this.roomName = reservation.getRoom().getName();
        this.roomType  = reservation.getRoom().getRoomType();
        this.minCapacity = reservation.getRoom().getMinCapacity();
        this.maxCapacity = reservation.getRoom().getMaxCapacity();
        this.minSpend = reservation.getRoom().getMinSpend();
    }

    public void validate(){
        //validates the user input DTO
        // no implementation yet
    }
}
