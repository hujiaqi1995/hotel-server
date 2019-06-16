package com.xd.hotel.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * Created by jiaqi on 2019/6/13 10:19 PM
 */

@Entity
@Table(name = "history")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class History implements Serializable {
    private static final long serialVersionUID = 233L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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
