package com.reservation.dining.repository;

import com.reservation.dining.dto.RestaurantDTO;
import com.reservation.dining.dto.SearchResult;
import com.reservation.dining.model.Restaurant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface RestaurantRepository extends JpaRepository<Restaurant, Long> {
    @Query(value = "SELECT rs.id, rs.name, rm.name as room_name, rm.id as room_id, rm.room_type, rm.min_capacity, rm.max_capacity, rm.min_spend " +
            "FROM " +
            "restaurant rs " +
            "inner join room rm on rm.restaurant_id  = rs.id " +
            "left join reservation r on r.room_id = rm.id and r.booking_start_time = ?4 " +
            "WHERE " +
            "ST_DWithin(location, ST_SetSRID(ST_MakePoint(?1, ?2), 0), ?3) " +
            "and ?5 between rm.min_capacity and rm.max_capacity " +
            "and r.id is null ", nativeQuery = true)
    List<SearchResult> findWithinDistance(double longitude, double latitude, double distanceInMeters, Date requestedTime, int persons);
}

