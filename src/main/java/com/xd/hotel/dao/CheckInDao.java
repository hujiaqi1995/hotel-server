package com.xd.hotel.dao;

import com.xd.hotel.model.CheckIn;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;
import java.util.List;

/**
 * Created by jiaqi on 2019/6/13 10:47 PM
 */
public interface CheckInDao extends JpaRepository<CheckIn, Integer> {

    CheckIn findByRoomNumber(String roomNumber);

    List<CheckIn> findByStartTimeAfter(LocalDateTime fromDate);
}
