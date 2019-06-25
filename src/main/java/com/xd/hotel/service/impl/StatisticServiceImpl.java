package com.xd.hotel.service.impl;

import com.xd.hotel.dao.CheckInDao;
import com.xd.hotel.dao.CustomerDao;
import com.xd.hotel.dao.CustomerEatDao;
import com.xd.hotel.model.CheckIn;
import com.xd.hotel.model.Customer;
import com.xd.hotel.service.StatisticService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

/**
 * Created by jiaqi on 2019/6/14 2:14 PM
 */

@Service
public class StatisticServiceImpl implements StatisticService {
    @Autowired
    private CheckInDao checkInDao;

    @Autowired
    private CustomerDao customerDao;

    @Autowired
    private CustomerEatDao customerEatDao;

    @Override
    public Integer getIncome(LocalDateTime fromDate) {
        return 0;
    }

    @Override
    public Integer getCustomerEatCount(String identityNumber) {
        return customerEatDao.countAllByIdentityNumber(identityNumber);
    }

    @Override
    public Integer getCustomersToday() {
        return customerDao.findAll().stream()
                .filter(customer ->
                        customer.isStatus() && customer.getEndTime().toLocalDate().isAfter(LocalDate.now())
                )
                .map(c -> 1)
                .reduce(Integer::sum)
                .orElse(0);
    }
}
