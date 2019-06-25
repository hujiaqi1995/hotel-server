package com.xd.hotel.controller;

import com.xd.hotel.dto.CheckInDTO;
import com.xd.hotel.dto.Common;
import com.xd.hotel.dto.HistoryDTO;
import com.xd.hotel.model.CheckIn;
import com.xd.hotel.model.Customer;
import com.xd.hotel.model.History;
import com.xd.hotel.model.Room;
import com.xd.hotel.service.CheckInService;
import com.xd.hotel.service.CustomerService;
import com.xd.hotel.service.HistoryService;
import com.xd.hotel.service.RoomService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
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
@Slf4j
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
        List data = checkInService.findAll();
        log.info("获取登记列表", data);
        return Common.of(Common.SUCCESS, "返回登记列表", data);
    }

    @ApiOperation("保存开房信息")
    @PostMapping("/insertCustomer")
    @Transactional
    public Common insertCustomer(@RequestBody Customer customer) {
        log.info("添加顾客");
        Room room = roomService.findByRoomNumber(customer.getRoomNumber());
        // 房间存在并且空闲
        if (room != null && room.getStatus() == 0) {
            // 更新房间状态
            room.setStatus((short) 1);
            roomService.updateRoom(room);

            // 更新用户信息
            if (customerService.findByIdentityNumber(customer.getIdentityNumber()) == null) {
                customer.setUpdateTime(LocalDateTime.now());
                customer.setStatus(true);
            } else {
                customer.setCreateTime(LocalDateTime.now());
                customer.setUpdateTime(LocalDateTime.now());
            }
            customerService.add(customer);

            return Common.of(Common.SUCCESS, "登记成功");
        }
        return Common.of(Common.FAILED, "登记失败");
    }

    @ApiOperation("退房")
    @GetMapping("/deleteCheckIn")
    public Common deleteCheckIn(@RequestParam("roomNumber") String roomNumber) {
        log.info("退房, roomNumber = "+ roomNumber);
        Room room = roomService.findByRoomNumber(roomNumber);
        Customer customer = customerService.findByRoomNumber(roomNumber);
        if (room != null && customer != null) {

            // 添加历史信息
            History history = HistoryDTO.convert(room, customer);
            historyService.add(history);

            // 标记顾客状态为false
            customer.setStatus(false);
            customer.setUpdateTime(LocalDateTime.now());
            customerService.update(customer);

            // 更新房间信息
            room.setStatus((short) 0);
            room.setUpdateTime(LocalDateTime.now());
            roomService.updateRoom(room);
            return Common.of(Common.SUCCESS, "删除登记成功");
        }
        return Common.of(Common.FAILED, "退房失败");
    }

    @ApiOperation("查询空余房间")
    @GetMapping("/getFreeRoom")
    public Common getFreeRoom() {
        log.info("查询空余房间");
        List<String> roomNumberList = roomService.findAll().stream()
                .filter(room -> room.getStatus() == (short) 0)
                .map(Room::getRoomNumber)
                .collect(Collectors.toList());
        return Common.of(Common.SUCCESS, "获取空余房间号成功", roomNumberList);
    }

    @ApiOperation("更换房间")
    @GetMapping("/changeRoom")
    @Transactional
    public Common changeRoom(@RequestParam("from") String from, @RequestParam("to") String to) {
        log.info("更换房间");
        // 更新顾客房间号
        Room curRoom = roomService.findByRoomNumber(from);
        Room nextRoom = roomService.findByRoomNumber(to);
        Customer customer = customerService.findByRoomNumber(from);
        if (curRoom != null && nextRoom != null && nextRoom.getStatus() == (short) 0 && customer != null) {

            // 更新房间信息
            curRoom.setStatus((short) 0);
            curRoom.setUpdateTime(LocalDateTime.now());
            nextRoom.setStatus((short) 1);
            nextRoom.setUpdateTime(LocalDateTime.now());

            roomService.addRoom(curRoom);
            roomService.addRoom(nextRoom);

            //更新顾客信息
            customer.setRoomNumber(to);
            customer.setUpdateTime(LocalDateTime.now());
            customerService.update(customer);

            // 更新住房历史
            customer.setEndTime(LocalDateTime.now());
            History history = HistoryDTO.convert(curRoom, customer);
            historyService.add(history);
            return Common.of(Common.SUCCESS, "换房成功");
        }
        return Common.of(Common.FAILED, "换房失败");
    }

}
