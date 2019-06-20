package com.xd.hotel.dao;

import com.xd.hotel.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Created by jiaqi on 2019/6/13 10:46 PM
 */
public interface CustomerDao extends JpaRepository<Customer, String> {
    List<Customer> findByName(String name);

    Customer findByIdentityNumber(String identityNumber);

    void deleteByIdentityNumber(String identityNumber);

    Customer findByRoomNumber(String roomNumber);

}
