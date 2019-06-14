package com.xd.hotel.dto;

import com.xd.hotel.modol.CheckIn;
import com.xd.hotel.modol.Customer;
import com.xd.hotel.modol.Room;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDateTime;

/**
 * Created by jiaqi on 2019/6/14 11:59 AM
 */

@Data
@AllArgsConstructor
public class CheckInDTO {

    public static CheckIn convert(Room room, Customer customer) {
        return CheckIn.builder()
                .roomNumber(room.getRoomNumber())
                .status(room.getStatus())
                .roomType(room.getRoomType())
                .startTime(customer.getStartTime())
                .endTime(customer.getEndTime())
                .roomPrice(room.getRoomPrice())
                .name(customer.getName())
                .sex(customer.getSex())
                .identityNumber(customer.getIdentityNumber())
                .note(customer.getNote())
                .build();
    }

    public static Customer toCustomer(CheckIn checkIn) {
        return Customer.builder()
                .roomNumber(checkIn.getRoomNumber())
                .name(checkIn.getName())
                .sex(checkIn.getSex())
                .identityNumber(checkIn.getIdentityNumber())
                .startTime(checkIn.getStartTime())
                .endTime(checkIn.getEndTime())
                .note(checkIn.getNote())
                .updateTime(LocalDateTime.now())
                .build();
    }

}
