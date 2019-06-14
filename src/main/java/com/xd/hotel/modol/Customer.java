package com.xd.hotel.modol;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDateTime;

/**
 * Created by jiaqi on 2019/6/13 9:35 PM
 */

@Entity
@Table(name = "customer")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Customer {

    @Id
    private String roomNumber;

    private String name;

    private Short sex;

    private String identityNumber;

    private LocalDateTime startTime;

    private LocalDateTime endTime;

    private String note;

    private LocalDateTime createTime;

    private LocalDateTime updateTime;
}
