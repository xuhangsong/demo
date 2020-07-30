package com.xhs.datasource.demo.interrcpt;


import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @author xuhan  build  2019/3/18
 */
//@Configuration
public class MyWebMvcConfiguration implements WebMvcConfigurer {
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        System.out.println("将拦截器注册进入");
        registry.addInterceptor(new JwtInterrcpt()).addPathPatterns("/**").excludePathPatterns("/login/**");
    }
}
