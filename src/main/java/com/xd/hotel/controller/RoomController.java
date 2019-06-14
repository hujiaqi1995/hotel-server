package com.xd.hotel.controller;

import com.xd.hotel.dto.Common;
import com.xd.hotel.modol.Room;
import com.xd.hotel.service.RoomService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

/**
 * Created by jiaqi on 2019/6/14 1:24 PM
 */

@RestController
@RequestMapping("/hotelMgmt/roomMgmt")
@Api(tags = "RoomController", description = "房间管理")
public class RoomController {

    @Autowired
    private RoomService roomService;

    @ApiOperation("获取房间列表")
    @GetMapping("/listRoom")
    public Common listRoom() {
        List<Room> roomList = roomService.findAll();
        return Common.of(Common.SUCCESS, "获取房间列表成功", roomList);
    }

    @ApiOperation("添加房间")
    @PostMapping("/insertRoom")
    public Common insertRoom(@RequestBody Room room) {
        room.setCreateTime(LocalDateTime.now());
        roomService.addRoom(room);
        return Common.of(Common.SUCCESS, "添加房间成功");
    }

    @ApiOperation("更新房间信息")
    @PostMapping("/updateRoom")
    public Common updateRoom(@RequestBody Room room) {
        room.setUpdateTime(LocalDateTime.now());
        roomService.updateRoom(room);
        return Common.of(Common.SUCCESS, "更新房间成功");
    }

    @ApiOperation("删除房间")
    @DeleteMapping("/deleteRoom")
    public Common deleteRoom(@RequestParam("rid") Integer rid) {
        Room room = roomService.findById(rid);
        if (room != null) {
            roomService.deleteRoom(room);
            return Common.of(Common.SUCCESS, "删除房间成功");
        } else {
            return Common.of(Common.SUCCESS, "删除房间失败");
        }
    }
}