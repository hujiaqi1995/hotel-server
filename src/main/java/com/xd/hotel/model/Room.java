package com.xd.hotel.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

/**
 * Created by jiaqi on 2019/6/13 9:24 PM
 */

@Entity
@Table(name = "room")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Room {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer rid;

    private String roomNumber;

    // 房间类型
    private String roomType;

    // 0空 1有人入住 2维修
    private Short status;

    private Integer roomPrice;

    private String note;

    private LocalDateTime createTime;

    private LocalDateTime updateTime;

    public Room(String roomNumber, String roomType, Short status, Integer roomPrice, String note, LocalDateTime createTime, LocalDateTime updateTime) {
        this.roomNumber = roomNumber;
        this.roomType = roomType;
        this.status = status;
        this.roomPrice = roomPrice;
        this.note = note;
        this.createTime = createTime;
        this.updateTime = updateTime;
    }

    public Room(String roomNumber, String roomType, Short status, Integer roomPrice, String note) {
        this.roomNumber = roomNumber;
        this.roomType = roomType;
        this.status = status;
        this.roomPrice = roomPrice;
        this.note = note;
    }
}
