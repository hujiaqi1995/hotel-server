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
        HttpSession session = request.getSession();
        if ((boolean) session.getAttribute("isLogin")) {
            return true;
        }
        response.sendRedirect("/");
        return false;
    }
}