package com.xd.hotel.controller;

import com.xd.hotel.dto.Common;
import com.xd.hotel.model.Customer;
import com.xd.hotel.service.CustomerEatService;
import com.xd.hotel.service.CustomerService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author jiaqi
 * @date 2019/6/22
 * @contact jqhu340@gmail.com
 */

@RestController
@RequestMapping("/hotelMgmt/customer")
@Api(tags = "CustomerController", description = "顾客信息处理")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @Autowired
    private CustomerEatService customerEatService;

    @GetMapping("/liveIn")
    @ApiOperation("获取所有入住的顾客")
    public Common findCustomersLiveIn() {
        List<Customer> data = customerService.findAll().stream()
                .filter(customer -> customer.isStatus())
                .collect(Collectors.toList());
        return Common.of(Common.SUCCESS, "获取入住顾客列表成功", data);
    }

    @GetMapping("all")
    @ApiOperation("获取所有来过的顾客")
    public Common findAll() {
        List<Customer> data = customerService.findAll();
        return Common.of(Common.SUCCESS, "获取所有顾客列表成功", data);
    }

    @PostMapping("eat")
    @ApiOperation("添加就餐记录")
    public Common eat(String identityNumber) {
        Customer customer = customerService.findByIdentityNumber(identityNumber);
        if (customer != null && customer.isStatus()) {
            customerEatService.eat(identityNumber);
            return Common.of(Common.SUCCESS, "添加就餐记录成功");
        } else {
            return Common.of(Common.FAILED, "添加就餐记录失败");
        }
    }

}
