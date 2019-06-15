package com.xd.hotel.service.impl;

import com.xd.hotel.dao.CheckInDao;
import com.xd.hotel.model.CheckIn;
import com.xd.hotel.service.StatisticService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

/**
 * Created by jiaqi on 2019/6/14 2:14 PM
 */

@Service
public class StatisticServiceImpl implements StatisticService {
    @Autowired
    private CheckInDao checkInDao;

    @Override
    public Integer getIncome(LocalDateTime fromDate) {
        return checkInDao.findByStartTimeAfter(fromDate).stream()
                .map(CheckIn::getRoomPrice)
                .reduce(Integer::sum)
                .orElse(0);
    }

    @Override
    public Integer getCartCount(String identityNumber) {
        return null;
    }
}
