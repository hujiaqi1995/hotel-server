package com.xd.hotel.modol;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.UniqueElements;

import javax.persistence.*;

/**
 * Created by jiaqi on 2019/6/13 9:32 PM
 */

@Entity
@Table(name = "user")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer uid;

    private String username;

    private String password;

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }
}
