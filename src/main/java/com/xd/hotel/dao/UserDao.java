package com.xd.hotel.dao;

import com.xd.hotel.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by jiaqi on 2019/6/13 10:45 PM
 */
public interface UserDao extends JpaRepository<User, Integer> {
    User findByUsername(String username);
}
