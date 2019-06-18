package com.xd.hotel.config;

import com.xd.hotel.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Created by jiaqi on 2019/6/14 2:32 PM
 */

@Component
public class RoleInterceptor implements HandlerInterceptor {


    private LoginService loginService;

    public RoleInterceptor(LoginService loginService) {
        this.loginService = loginService;
    }

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        return true;
//        HttpSession session = request.getSession();
//
//        if (session.getAttribute("isLogin") == null) {
//            System.out.println("isLogin = null");
//        }
//        if (session.getAttribute("isLogin") != null && (boolean) session.getAttribute("isLogin")) {
//            return true;
//        }
//        System.out.println("没有登录");
//        response.sendRedirect("/");
//        return false;
    }
}
