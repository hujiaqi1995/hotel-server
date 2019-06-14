package com.xd.hotel.dao;

import com.xd.hotel.modol.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

/**
 * Created by jiaqi on 2019/6/13 10:45 PM
 */
public interface UserDao extends JpaRepository<User, Integer> {
    User findByUsername(String username);
}
