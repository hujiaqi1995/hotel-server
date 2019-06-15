package com.xd.hotel.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

/**
 * Created by jiaqi on 2019/6/13 9:26 PM
 */

@Entity
@Table(name = "checkin")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor

// 登记信息表
public class CheckIn {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer cid;

    private String roomNumber;

    // 房间状态 0空 1有人
    private Short status;

    // 房间类型 大床房 双人间 三人间
    private String roomType;

    private LocalDateTime startTime;

    private LocalDateTime endTime;

    // 定价
    private Integer roomPrice;

    private String name;

    // 0男 1女
    private Short sex;

    private String identityNumber;

    // 备注
    private String note;

    public CheckIn(String roomNumber, Short status, String roomType, LocalDateTime startTime, LocalDateTime endTime, Integer roomPrice, String name, Short sex, String identityNumber, String note) {
        this.roomNumber = roomNumber;
        this.status = status;
        this.roomType = roomType;
        this.startTime = startTime;
        this.endTime = endTime;
        this.roomPrice = roomPrice;
        this.name = name;
        this.sex = sex;
        this.identityNumber = identityNumber;
        this.note = note;
    }
}
