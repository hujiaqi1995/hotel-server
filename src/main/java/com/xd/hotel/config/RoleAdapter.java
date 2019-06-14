package com.xd.hotel.config;

import com.xd.hotel.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * Created by jiaqi on 2019/6/14 2:30 PM
 */

@Component
public class RoleAdapter implements WebMvcConfigurer {

    @Autowired
    private LoginService loginService;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new RoleInterceptor(loginService))
                .addPathPatterns("/hotelMgmt/**");
    }

}
