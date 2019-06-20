package com.xd.hotel.controller;

import com.xd.hotel.dto.Common;
import com.xd.hotel.model.Customer;
import com.xd.hotel.model.Room;
import com.xd.hotel.service.CustomerService;
import com.xd.hotel.service.RoomService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
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
@Slf4j
public class RoomController {

    @Autowired
    private RoomService roomService;

    @Autowired
    private CustomerService customerService;

    @ApiOperation("获取房间列表")
    @GetMapping("/listRoom")
    public Common listRoom() {
        log.info("获取房间列表");
        List<Room> roomList = roomService.findAll();
        return Common.of(Common.SUCCESS, "获取房间列表成功", roomList);
    }

    @ApiOperation("添加房间")
    @PostMapping("/insertRoom")
    public Common insertRoom(@RequestBody Room room) {
        log.info("添加房间");
        room.setCreateTime(LocalDateTime.now());
        if(roomService.addRoom(room)) {
            return Common.of(Common.SUCCESS, "添加房间成功");
        } else {
            return Common.of(Common.FAILED, "添加房间失败");
        }

    }

    @ApiOperation("更新房间信息")
    @PostMapping("/updateRoom")
    public Common updateRoom(@RequestBody Room room) {
        log.info("更新房间信息");
        room.setUpdateTime(LocalDateTime.now());
        if (roomService.updateRoom(room)) {
            return Common.of(Common.SUCCESS, "更新房间成功");
        } else {
            return Common.of(Common.FAILED, "更新房间失败");
        }

    }

    @ApiOperation("删除房间")
    @GetMapping("/deleteRoom")
    public Common deleteRoom(@RequestParam("roomNumber") String roomNumber) {
        log.info("删除房间");
        Room room = roomService.findByRoomNumber(roomNumber);
        Customer customer = customerService.findByRoomNumber(roomNumber);
        if (room != null) {
            roomService.deleteRoom(room);
            if (customer != null) {
                customer.setRoomNumber(null);
                customer.setUpdateTime(LocalDateTime.now());
                customerService.update(customer);
            }
            return Common.of(Common.SUCCESS, "删除房间成功");
        } else {
            return Common.of(Common.FAILED, "删除房间失败");
        }
    }

    @ApiOperation("房间是否存在")
    @GetMapping("/isRoomNoExists")
    public Common isRoomNoExists(@RequestParam("roomNumber") String roomNumber) {
        boolean res = roomService.exist(roomNumber);
        return res ? Common.of(Common.SUCCESS, "房间存在", true) : Common.of(Common.FAILED, "房间不存在", false);
    }
}
