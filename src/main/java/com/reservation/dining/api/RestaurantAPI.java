package com.reservation.dining.api;

import com.reservation.dining.config.Response;
import com.reservation.dining.config.RestaurantResponse;
import com.reservation.dining.dto.SearchParams;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import com.reservation.dining.dto.RestaurantDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/api/restaurants")
public interface RestaurantAPI {
    @Operation(summary = "Search a list of restaurants", responses = {
            @ApiResponse(description = "Successful Operation", responseCode = "200", content = @Content(mediaType = "application/json", schema = @Schema(implementation = RestaurantResponse.class))),
            @ApiResponse(responseCode = "404", description = "Not found", content = @Content(mediaType = "application/json", schema = @Schema(implementation = Response.class))),
            @ApiResponse(responseCode = "401", description = "Authentication Failure", content = @Content(schema = @Schema(hidden = true))) })

    @PostMapping("/searchRestaurants")
    public ResponseEntity<RestaurantResponse> searchRestaurants(@RequestBody SearchParams searchParams) ;
}
