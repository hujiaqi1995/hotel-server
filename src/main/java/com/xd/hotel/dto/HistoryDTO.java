package com.xd.hotel.dto;

import com.xd.hotel.model.Customer;
import com.xd.hotel.model.History;
import com.xd.hotel.model.Room;

/**
 * Created by jiaqi on 2019/6/14 12:11 PM
 */
public class HistoryDTO {

    public static History convert(Room room, Customer customer) {
        return History.builder()
                .roomNumber(customer.getRoomNumber())
                .startTime(customer.getStartTime())
                .endTime(customer.getEndTime())
                .name(customer.getName())
                .sex(customer.getSex())
                .identityNumber(customer.getIdentityNumber())
                .price(room.getRoomPrice())
                .note(customer.getNote())
                .build();

    }
}
