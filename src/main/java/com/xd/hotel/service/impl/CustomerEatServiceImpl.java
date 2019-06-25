package com.xd.hotel.service.impl;

import com.xd.hotel.dao.CustomerDao;
import com.xd.hotel.dao.CustomerEatDao;
import com.xd.hotel.model.Customer;
import com.xd.hotel.model.CustomerEat;
import com.xd.hotel.service.CustomerEatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

/**
 * Created by jiaqi on 2019/6/16 9:20 AM
 */

@Service
public class CustomerEatServiceImpl implements CustomerEatService {

    @Autowired
    private CustomerEatDao customerEatDao;
    @Autowired
    private CustomerDao customerDao;

    @Override
    public void eat(String identityNumber) {
        CustomerEat customerEat = new CustomerEat(identityNumber, LocalDateTime.now());
        customerEatDao.save(customerEat);
    }
}
