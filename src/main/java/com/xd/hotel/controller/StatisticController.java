package com.xd.hotel.controller;

import com.xd.hotel.dto.Common;
import com.xd.hotel.service.StatisticService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

/**
 * Created by jiaqi on 2019/6/14 2:13 PM
 */


@Api(tags = "StatisticController", description = "统计模块")
@RestController
@RequestMapping("/hotelMgmt/statisticMgmt")
public class StatisticController {

    @Autowired
    private StatisticService statisticService;

    @ApiOperation("收入统计")
    @GetMapping("/getIncome")
    public ResponseEntity<Integer> getIncome(@RequestParam(value = "fromDate") LocalDateTime fromDate) {
        Integer income = statisticService.getIncome(fromDate);
        return new ResponseEntity<>(income, HttpStatus.OK);
    }

}
