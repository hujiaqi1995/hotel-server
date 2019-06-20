package com.xd.hotel.service.impl;

import com.xd.hotel.model.Room;
import com.xd.hotel.service.RoomService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

/**
 * Created by jiaqi on 2019/6/20 11:15 PM
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class RoomServiceImplTest {

    @Autowired
    private RoomService roomService;
    @Test
    public void findByRoomNumber() {
        Room room = roomService.findByRoomNumber("203");
        Assert.assertNotNull(room);

    }
}
