package com.xd.hotel.controller;

import com.xd.hotel.dto.CheckInDTO;
import com.xd.hotel.dto.Common;
import com.xd.hotel.dto.HistoryDTO;
import com.xd.hotel.modol.CheckIn;
import com.xd.hotel.modol.Customer;
import com.xd.hotel.modol.History;
import com.xd.hotel.modol.Room;
import com.xd.hotel.service.CheckInService;
import com.xd.hotel.service.CustomerService;
import com.xd.hotel.service.HistoryService;
import com.xd.hotel.service.RoomService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by jiaqi on 2019/6/14 11:48 AM
 */

@RestController
@RequestMapping("/hotelMgmt/checkInMgmt")
@Api(tags = "CheckInController", description = "登记列表")
public class CheckInController {

    @Autowired
    private CheckInService checkInService;

    @Autowired
    private RoomService roomService;

    @Autowired
    private CustomerService customerService;

    @Autowired
    private HistoryService historyService;

    @ApiOperation("获取所有登记信息")
    @GetMapping("/listCheckIn")
    public Common list() {
        List list = checkInService.findAll();
        return Common.of(Common.SUCCESS, "返回登记列表", list);
    }

    @ApiOperation("添加顾客")
    @PostMapping("/insertCustomer")
    @Transactional
    public Common insertCustomer(@RequestBody Customer customer) {
        Room room = roomService.getOne(customer.getRoomNumber());
        if (room != null) {
            // 更新房间状态
            room.setStatus((short) 1);
            roomService.updateRoom(room);

            // 更新用户信息
            if (customerService.findByIdentityNumber(customer.getIdentityNumber()) == null) {
                customer.setCreateTime(LocalDateTime.now());
            }
            customer.setUpdateTime(LocalDateTime.now());
            customerService.add(customer);

            // 添加登记记录
            CheckIn checkIn = CheckInDTO.convert(room, customer);
            checkInService.add(checkIn);

            // 添加入住记录
            History history = HistoryDTO.convert(room, customer);
            historyService.add(history);

            return Common.of(Common.SUCCESS, "登记成功");
        }
        return Common.of(Common.FAILED, "登记失败");
    }

    @ApiOperation("删除登记信息")
    @GetMapping("/deleteCheckIn")
    public Common deleteCheckIn(@RequestParam("cid") Integer cid) {
        checkInService.delete(cid);
        return Common.of(Common.SUCCESS, "删除登记成功");
    }

    @ApiOperation("查询空余房间")
    @GetMapping("/getFreeRoom")
    public Common getFreeRoom() {
        List<String> roomNumberList = roomService.findAll().stream()
                .filter(room -> room.getStatus().equals(1))
                .map(Room::getRoomNumber)
                .collect(Collectors.toList());
        return Common.of(Common.SUCCESS, "获取空余房间号成功", roomNumberList);
    }

    @ApiOperation("更换房间")
    @GetMapping("/changeRoom")
    @Transactional
    public Common changeRoom(@RequestParam("rid") Integer rid, @RequestParam("roomNumber") String roomNumber) {
        // 更新顾客房间号
        Room curRoom = roomService.findById(rid);
        if (curRoom != null) {
            CheckIn checkIn = checkInService.findByRoomNumber(curRoom.getRoomNumber());
            // 更新房间信息
            Room nextRoom = roomService.getOne(roomNumber);
            curRoom.setStatus((short)0);
            nextRoom.setStatus((short)1);
            roomService.addRoom(curRoom);
            roomService.addRoom(nextRoom);

            //更新顾客信息
            Customer customer = customerService.findByIdentityNumber(checkIn.getIdentityNumber());
            customer.setRoomNumber(roomNumber);
            customer.setUpdateTime(LocalDateTime.now());

            // 更新登记信息
            checkIn.setRoomNumber(roomNumber);
            checkIn.setRoomType(nextRoom.getRoomType());
            checkIn.setRoomPrice(nextRoom.getRoomPrice());
            checkIn.setStartTime(LocalDateTime.now());
            checkInService.add(checkIn);

            // 更新住房历史
            customer.setEndTime(LocalDateTime.now());
            History history = HistoryDTO.convert(curRoom, customer);
            historyService.add(history);
            return Common.of(Common.SUCCESS, "换房成功");
        }
        return Common.of(Common.FAILED, "换房失败");
    }

}