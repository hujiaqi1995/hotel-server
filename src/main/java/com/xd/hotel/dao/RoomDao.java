package com.xd.hotel.dao;

import com.xd.hotel.modol.Room;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by jiaqi on 2019/6/13 10:45 PM
 */
public interface RoomDao extends JpaRepository<Room, Integer> {
    Room findByRoomNumber(String roomNumber);
}
