package com.xd.hotel.service.impl;

import com.xd.hotel.dao.CheckInDao;
import com.xd.hotel.dao.CustomerDao;
import com.xd.hotel.dao.RoomDao;
import com.xd.hotel.dto.CheckInDTO;
import com.xd.hotel.model.CheckIn;
import com.xd.hotel.model.Room;
import com.xd.hotel.service.CheckInService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by jiaqi on 2019/6/14 12:08 AM
 */

@Service
public class CheckInServiceImpl implements CheckInService {

    @Autowired
    private CheckInDao checkInDao;
    @Autowired
    private RoomDao roomDao;

    @Autowired
    private CustomerDao customerDao;

    @Override
    public List<CheckIn> findAll() {
//        List<Room> rooms = roomDao.findAll();
//        List<CheckIn> checkIns = new ArrayList<>();
//        for (Room room:rooms) {
//            if (room.getStatus() == (short)1) {
//                // 已入住
//                checkIns.add(CheckInDTO.convert(room, customerDao.findByRoomNumber(room.getRoomNumber())));
//            } else {
//                // 空闲
//                checkIns.add(CheckInDTO.convert(room));
//            }
//        }

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
    public CheckIn findById(Integer cid) {
        return checkInDao.findById(cid).orElse(null);
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
