package com.reservation.dining.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;
import io.swagger.v3.oas.annotations.media.Schema;

import java.util.Date;
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class SearchParams {
    private Double latitude;
    private Double longitude;
    @Schema(description = "Reservation start time", example = "2025-11-15T18:00:00")
    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss")
    private Date requestedTime;
    private int partySize;
    private Double searchDistance;

    public void validate(){
        //validates the user input DTO
        // no implementation yet
    }
}
