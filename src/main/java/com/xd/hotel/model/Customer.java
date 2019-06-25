package com.xd.hotel.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
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
public class Customer implements Serializable {
    private static final long serialVersionUID = 233L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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

    // 是否入住
    private boolean status;
}
