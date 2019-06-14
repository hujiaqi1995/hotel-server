package com.xd.hotel.service.impl;

import com.xd.hotel.dao.CheckInDao;
import com.xd.hotel.modol.CheckIn;
import com.xd.hotel.modol.Customer;
import com.xd.hotel.modol.Room;
import com.xd.hotel.service.CheckInService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by jiaqi on 2019/6/14 12:08 AM
 */

@Service
public class CheckInServiceImpl implements CheckInService {

    @Autowired
    private CheckInDao checkInDao;

    @Override
    public List<CheckIn> findAll() {
        return checkInDao.findAll();
    }

    @Override
    public List<CheckIn> findAll(Pageable pageable) {
        return checkInDao.findAll(pageable).getContent();
    }

    @Override
    public CheckIn findByRoomNumber(String roomNumber) {
        return checkInDao.findByRoomNumber(roomNumber);
    }

    @Override
    public void add(CheckIn checkIn) {
        checkInDao.save(checkIn);
    }

    @Override
    public void delete(Integer cid) {
        checkInDao.findById(cid).ifPresent(r -> checkInDao.delete(r));
    }

    @Override
    public List<String> getFreeRoom() {
        return checkInDao.findAll().stream()
                .filter(room -> room.getStatus().equals(0))
                .map(r -> r.getRoomNumber())
                .collect(Collectors.toList());
    }
}
