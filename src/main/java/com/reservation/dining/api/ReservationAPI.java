package com.reservation.dining.api;
import com.reservation.dining.config.ReservationResponse;
import com.reservation.dining.config.ReservationsResponse;
import com.reservation.dining.config.Response;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import com.reservation.dining.dto.ReservationDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/api/reservations")
public interface ReservationAPI {
    @Operation(summary = "Create a new reservations", responses = {
            @ApiResponse(description = "Reservation Created", responseCode = "201", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ReservationResponse.class))),
            @ApiResponse(responseCode = "404", description = "Not found", content = @Content),
            @ApiResponse(responseCode = "409", description = "Spot is already booked", content = @Content(mediaType = "application/json", schema = @Schema(implementation = Response.class))),
            @ApiResponse(responseCode = "400", description = "Invalid Data", content = @Content(mediaType = "application/json", schema = @Schema(implementation = Response.class))),
            @ApiResponse(responseCode = "401", description = "Authentication Failure", content = @Content(schema = @Schema(hidden = true))) })
    @PostMapping
    public ResponseEntity<ReservationResponse> createReservation(@RequestBody ReservationDTO reservation) ;

    @Operation(summary = "Get list of reservations made by user", responses = {
            @ApiResponse(description = "Successful Operation", responseCode = "200", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ReservationsResponse.class))),
            @ApiResponse(responseCode = "404", description = "Not found", content = @Content),
            @ApiResponse(responseCode = "401", description = "Authentication Failure", content = @Content(schema = @Schema(hidden = true))) })
    @GetMapping("/user/{userId}")
    public ResponseEntity<ReservationsResponse> getUserReservations(@RequestParam(name = "userId", required=true) String userId);

    @Operation(summary = "Get list of reservations of a restaurant", responses = {
            @ApiResponse(description = "Successful Operation", responseCode = "200", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ReservationsResponse.class))),
            @ApiResponse(responseCode = "404", description = "Not found", content = @Content),
            @ApiResponse(responseCode = "401", description = "Authentication Failure", content = @Content(schema = @Schema(hidden = true))) })
    @GetMapping("/restaurant/{restaurantId}")
    public ResponseEntity<ReservationsResponse> getRestaurantReservations(@RequestParam(name = "restaurantId", required=true) Long restaurantId);

    @Operation(summary = "Cancel a reservation", responses = {
            @ApiResponse(description = "Successful Deletion", responseCode = "204", content = @Content(mediaType = "application/json", schema = @Schema(hidden = true))),
            @ApiResponse(responseCode = "404", description = "Not found", content = @Content),
            @ApiResponse(responseCode = "401", description = "Authentication Failure", content = @Content(schema = @Schema(hidden = true))) })
    @DeleteMapping("/{id}")
    public ResponseEntity<Object> cancelReservation(@RequestParam(name = "id", required=true) Long id);
}
