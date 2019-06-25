package com.xd.hotel.service;

import com.xd.hotel.model.User;

/**
 * Created by jiaqi on 2019/6/13 9:40 PM
 */
public interface LoginService {
    boolean login(String username, String password);

    boolean add(String username, String password);

    User findByUserName(String username);

    String refreshToken(String oldToken);

    User findById(Integer uid);

}
