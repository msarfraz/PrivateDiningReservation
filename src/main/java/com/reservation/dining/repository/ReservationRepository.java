package com.reservation.dining.repository;

import com.reservation.dining.model.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface ReservationRepository extends JpaRepository<Reservation, Long> {
    public List<Reservation> findAllByUserId(String userId);
    public List<Reservation> findAllByRestaurantId(Long restaurantId);
    @Query(value = "insert into reservation(restaurant_id, room_id, user_id, booking_start_time, booking_end_time, persons) " +
            "select :restaurant_id, :room_id, :user_id, CAST(:booking_start_time AS TIMESTAMP WITHOUT TIME ZONE), CAST(:booking_end_time AS TIMESTAMP WITHOUT TIME ZONE), :persons " +
            "from (select 1) t " +
            "where not exists( " +
            "select 1 from reservation " +
            "where restaurant_id = :restaurant_id " +
            "and room_id = :room_id " +
            "and booking_start_time  = :booking_start_time " +
            ") RETURNING id ", nativeQuery = true)
    public Long createReservation(@Param("restaurant_id") Long restaurant_id, @Param("room_id")Long room_id, @Param("user_id")String user_id,@Param("booking_start_time") Date booking_start_time,@Param("booking_end_time") Date booking_end_time,@Param("persons") int persons);
}