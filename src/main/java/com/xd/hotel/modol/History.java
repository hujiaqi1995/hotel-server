package com.xd.hotel.modol;

import lombok.Builder;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDateTime;

/**
 * Created by jiaqi on 2019/6/13 10:19 PM
 */

@Entity
@Table(name = "history")
@Data
@Builder
public class History {
    @Id
    @GeneratedValue
    private Integer hid;

    private String roomNumber;

    private LocalDateTime startTime;

    private LocalDateTime endTime;

    private String name;

    private Short sex;

    private String identityNumber;

    private Integer price;

    private String note;
}
