package com.xd.hotel.dao;

import com.xd.hotel.model.Room;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;


/**
 * Created by jiaqi on 2019/6/13 11:00 PM
 */

@SpringBootTest
@RunWith(SpringRunner.class)
public class RoomDaoTest {

    @Autowired
    RoomDao dao;

    @Test
    public void deleteRoom() {

    }

    @Test
    public void findByRoomNumber() {
        Room room = dao.findByRoomNumber("203");
        Assert.assertNotNull(room);
        System.out.println(room.toString());
    }

}