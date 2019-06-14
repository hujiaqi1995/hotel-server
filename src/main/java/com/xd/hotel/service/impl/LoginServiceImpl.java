package com.xd.hotel.service.impl;

import com.xd.hotel.dao.UserDao;
import com.xd.hotel.modol.User;
import com.xd.hotel.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by jiaqi on 2019/6/13 10:44 PM
 */

@Service
public class LoginServiceImpl implements LoginService {
    @Autowired
    private UserDao userDao;


    @Override
    public boolean login(String username, String password) {
        User user = userDao.findByUsername(username);
        if(user != null && user.getPassword().equals(password)) {
            return true;
        }
        return false;
    }

    @Override
    public boolean add(String username, String password) {
        User user = userDao.findByUsername(username);
        if (user == null) {
            user = new User(username, password);
            userDao.save(user);
            return true;
        }
        return false;
    }
}
