package com.xd.hotel.service;

import java.time.LocalDateTime;

/**
 * Created by jiaqi on 2019/6/14 2:10 PM
 */
public interface StatisticService {
    Long getIncome(LocalDateTime fromDate);

    Integer getCartCount(String identityNumber);
}
