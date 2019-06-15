package com.xd.hotel.service;

import com.xd.hotel.model.CheckIn;
import org.springframework.data.domain.Pageable;

import java.util.List;

/**
 * Created by jiaqi on 2019/6/13 9:41 PM
 */
public interface CheckInService {
    List<CheckIn> findAll();

    List<CheckIn> findAll(Pageable pageable);

    CheckIn findByRoomNumber(String roomNumber);

    void add(CheckIn checkIn);

    void delete(Integer cid);

    List<String> getFreeRoom();
}
