package com.xd.hotel.modol;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
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
    @GeneratedValue
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
}
