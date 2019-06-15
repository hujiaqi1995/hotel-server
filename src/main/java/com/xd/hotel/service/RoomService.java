package com.xd.hotel.service;

import com.xd.hotel.model.Room;

import java.util.List;

/**
 * Created by jiaqi on 2019/6/13 9:41 PM
 */
public interface RoomService {

    List<Room> findAll();

    Room findById(Integer rid);

    Room getOne(String roomNumber);

    boolean addRoom(Room room);

    boolean updateRoom(Room room);

    void deleteRoom(Room room);

    boolean exist(String roomNumber);
}
