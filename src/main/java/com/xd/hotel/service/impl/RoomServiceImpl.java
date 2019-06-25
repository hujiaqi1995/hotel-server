package com.xd.hotel.service.impl;

import com.xd.hotel.dao.CustomerDao;
import com.xd.hotel.dao.RoomDao;
import com.xd.hotel.model.Customer;
import com.xd.hotel.model.Room;
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
    @Autowired
    private CustomerDao customerDao;

    @Override
    public List<Room> findAll() {
        return roomDao.findAll();
    }

    @Override
    public Room findById(Integer rid) {
        return roomDao.findById(rid).orElse(null);
    }

    @Override
    public Room findByRoomNumber(String roomNumber) {
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
        Room old = roomDao.findByRoomNumber(room.getRoomNumber());
        if (old != null) {
            old.setRoomNumber(room.getRoomNumber());
            if (room.getRoomPrice() != null) {
                old.setRoomPrice(room.getRoomPrice());
                Customer customer = customerDao.findByRoomNumber(room.getRoomNumber());
                customer.setRoomNumber(room.getRoomNumber());
                customerDao.save(customer);
            }
            old.setRoomType(room.getRoomType());
            old.setNote(room.getNote());
            old.setUpdateTime(LocalDateTime.now());
            roomDao.save(old);
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
