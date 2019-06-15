package com.xd.hotel.modol;

import lombok.Builder;
import lombok.Data;

import javax.persistence.*;
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
    @GeneratedValue(strategy = GenerationType.AUTO)
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
