package com.xd.hotel.service.impl;

import com.xd.hotel.dao.RoomDao;
import com.xd.hotel.modol.Room;
import com.xd.hotel.service.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

/**
 * Created by jiaqi on 2019/6/13 10:54 PM
 */

@Service
public class RoomServiceImpl implements RoomService {
    @Autowired
    private RoomDao roomDao;

    @Override
    public List<Room> findAll() {
        return roomDao.findAll();
    }

    @Override
    public Room findById(Integer rid) {
        return roomDao.findById(rid).orElse(null);
    }

    @Override
    public Room getOne(String roomNumber) {
        return roomDao.findByRoomNumber(roomNumber);
    }

    @Override
    public boolean addRoom(Room room) {
        Room r = roomDao.findByRoomNumber(room.getRoomNumber());
        if (r == null) {
            roomDao.save(room);
            return true;
        }
        return false;
    }

    @Override
    public boolean updateRoom(Room room) {
        Room r = roomDao.findByRoomNumber(room.getRoomNumber());
        if (r != null) {
            room.setRid(r.getRid());
            room.setCreateTime(r.getCreateTime());
            room.setUpdateTime(LocalDateTime.now());
            roomDao.save(room);
            return true;
        }
        return false;
    }

    @Override
    public void deleteRoom(Room room) {
        roomDao.delete(room);
    }

    @Override
    public boolean exist(String roomNumber) {
        Room room = roomDao.findByRoomNumber(roomNumber);
        return room != null;
    }
}
