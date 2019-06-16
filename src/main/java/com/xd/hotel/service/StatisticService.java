package com.xd.hotel.service;

import java.time.LocalDateTime;

/**
 * Created by jiaqi on 2019/6/14 2:10 PM
 */
public interface StatisticService {
    // 收入统计
    Integer getIncome(LocalDateTime fromDate);

    // 顾客刷卡次数统计
    Integer getCustomerEatCount(String identityNumber);

    // 今日就餐人数统计
    Integer getCustomersToday();
}
