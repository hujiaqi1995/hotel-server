package com.xd.hotel.dao;

import com.xd.hotel.model.CustomerEat;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by jiaqi on 2019/6/16 9:19 AM
 */
public interface CustomerEatDao extends JpaRepository<CustomerEat, Integer> {

    Integer countAllByIdentityNumber(String identityNumber);

}
