package com.xd.hotel.service.impl;

import com.xd.hotel.dao.CustomerDao;
import com.xd.hotel.model.Customer;
import com.xd.hotel.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by jiaqi on 2019/6/13 11:51 PM
 */

@Service
public class CustomerServiceImpl implements CustomerService {
    @Autowired
    private CustomerDao customerDao;

    @Override
    public List<Customer> findAll() {
        return customerDao.findAll();
    }

    @Override
    public void add(Customer customer) {
        customerDao.save(customer);
    }

    @Override
    public void update(Customer customer) {
        customerDao.save(customer);
    }

    @Override
    public void delete(Customer customer) {
        customerDao.delete(customer);
    }

    @Override
    public List<Customer> findByName(String name) {
        return customerDao.findByName(name);
    }

    @Override
    public Customer findByRoomNumber(String roomNumber) {
        return customerDao.findByRoomNumber(roomNumber);
    }

    @Override
    public Customer findByIdentityNumber(String identityNumber) {
        return customerDao.findByIdentityNumber(identityNumber);
    }


}
