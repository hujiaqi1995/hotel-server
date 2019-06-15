package com.xd.hotel.service;

import com.xd.hotel.model.Customer;

import java.util.List;

/**
 * Created by jiaqi on 2019/6/13 11:26 PM
 */
public interface CustomerService {
    List<Customer> findAll();

    void add(Customer customer);

    void delete(String name);

    List<Customer> findByName(String name);

    Customer findByIdentityNumber(String identityNumber);
}
