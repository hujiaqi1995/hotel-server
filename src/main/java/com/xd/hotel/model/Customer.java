package com.xd.hotel.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
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
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

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
