package com.xd.hotel.controller;

import com.xd.hotel.dto.Common;
import com.xd.hotel.service.LoginService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * Created by jiaqi on 2019/6/14 11:28 AM
 */

@RestController
@RequestMapping("/login")
@Api(tags = "LoginController", description = "用户登录模块")
public class LoginController {
    @Autowired
    private LoginService loginService;

    @ApiOperation("登录")
    @PostMapping("/login")
    public Common login(HttpServletRequest request,
                        @RequestParam("username") String username,
                        @RequestParam("password") String password) {
        boolean res = loginService.login(username, password);
        if (res) {
            request.setAttribute("isLogin", "true");
            return Common.of(Common.SUCCESS, "登录成功");
        } else {
            return Common.of(Common.FAILED, "登录失败");
        }
    }

    @ApiOperation("登出")
    @GetMapping("/out")
    public Common logout(HttpSession session) {
        session.removeAttribute("isLogin");
        return Common.of(Common.SUCCESS, "注销成功");
    }
}
