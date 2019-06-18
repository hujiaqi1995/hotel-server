package com.xd.hotel.util;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.temporal.TemporalAdjusters;

/**
 * Created by jiaqi on 2019/6/18 5:28 PM
 */
public class Test {
    public static void main(String[] args) {
        LocalDate firstDayOfThisMonth = LocalDate.now().with(TemporalAdjusters.firstDayOfMonth());
        LocalTime localTime = LocalTime.of(0,0,0);
        LocalDateTime localDateTime = LocalDateTime.of(firstDayOfThisMonth, localTime);
        System.out.println(localDateTime);
    }
}
