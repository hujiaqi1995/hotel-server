package com.xd.hotel.controller;

import com.xd.hotel.dto.Common;
import com.xd.hotel.service.StatisticService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.temporal.TemporalAdjusters;

/**
 * Created by jiaqi on 2019/6/14 2:13 PM
 */


@Api(tags = "StatisticController", description = "统计模块")
@RestController
@RequestMapping("/hotelMgmt/statisticMgmt")
@Slf4j
public class StatisticController {

    @Autowired
    private StatisticService statisticService;

    // 暂不处理
    @ApiOperation("收入统计")
    @GetMapping("/getIncome")
    public Common getIncome(@RequestParam(value = "fromDate") LocalDateTime fromDate) {
        log.info("收入统计");
        Integer data = statisticService.getIncome(fromDate);
        return Common.of(Common.SUCCESS, "获取收入成功", data);
    }

    //暂不处理
    @ApiOperation("当月收入")
    @GetMapping("/getIncomeThisMonth")
    public Common getIncome() {
        LocalDate firstDayOfThisMonth = LocalDate.now().with(TemporalAdjusters.firstDayOfMonth());
        LocalTime localTime = LocalTime.of(0,0,0);
        LocalDateTime fromDate = LocalDateTime.of(firstDayOfThisMonth, localTime);
        Integer income = statisticService.getIncome(fromDate);
        return Common.of(Common.SUCCESS, "获取当月总收入成功", income);
    }

    @ApiOperation("统计今日就餐人数")
    @GetMapping("/getCustomersToday")
    public Common getCustomersToday() {
        log.info("今日就餐人数统计");
        Integer data = statisticService.getCustomersToday();
        return Common.of(Common.SUCCESS, "获取今日就餐人数成功", data);
    }

    @GetMapping("/getCustomerEatCount")
    public Common getCustomerEatCount(@RequestParam("identityNumber") String identityNumber) {
        log.info(String.format("身份证号为%s的用户的就餐次数统计", identityNumber));
        Integer data = statisticService.getCustomerEatCount(identityNumber);
        return Common.of(Common.SUCCESS, "获取就餐次数成功", data);
    }
}
