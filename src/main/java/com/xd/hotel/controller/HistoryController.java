package com.xd.hotel.controller;

import com.xd.hotel.dto.Common;
import com.xd.hotel.model.History;
import com.xd.hotel.service.HistoryService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by jiaqi on 2019/6/14 1:35 PM
 */

@RestController
@Api(tags = "HistoryController", description = "顾客入住历史记录")
@RequestMapping("/roomMgmt/history")
@Slf4j
public class HistoryController {
    @Autowired
    private HistoryService historyService;

    @ApiOperation("获取所有顾客的入住历史记录")
    @GetMapping("/listHistory")
    public Common listHistory() {
        log.info("获取所有人入住历史记录");
        List<History> data = historyService.findAll();
        return Common.of(Common.SUCCESS, "获取所有用户历史记录成功", data);
    }

    @ApiOperation("获取指定用户的入住历史记录")
    @GetMapping("/listHistory/{identityNumber}")
    public Common findHistory(@PathVariable("identityNumber") String identityNumber) {
        log.info("获取身份证为 " + identityNumber + " 的用户的历史记录");
        List<History> data = historyService.findByIdentityNumber(identityNumber);
        if (data != null) {
            return Common.of(Common.SUCCESS, "获取指定用户历史记录成功", data);
        } else {
            return Common.of(Common.FAILED, "未查到历史记录", data);
        }
    }
}
