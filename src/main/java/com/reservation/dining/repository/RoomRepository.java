package com.reservation.dining.repository;

import com.reservation.dining.dto.SearchResult;
import com.reservation.dining.model.Restaurant;
import com.reservation.dining.model.Room;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface RoomRepository extends JpaRepository<Room, Long> {

}

