package com.xd.hotel.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * Created by jiaqi on 2019/6/16 9:17 AM
 */

@Entity
@Table(name = "customer_eat_history")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CustomerEat implements Serializable {
    private static final long serialVersionUID = 233L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    private String identityNumber;

    private LocalDateTime eatTime;

    public CustomerEat(String identityNumber, LocalDateTime eatTime) {
        this.identityNumber = identityNumber;
        this.eatTime = eatTime;
    }
}
