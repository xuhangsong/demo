package com.xhs.datasource.demo.interrcpt;

import com.xhs.datasource.demo.utils.JwtTokenUtils;
import io.jsonwebtoken.Claims;
import io.leopard.web.servlet.CookieUtil;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;

/**
 * @author xuhan  build  2019/3/15
 */
public class JwtInterrcpt extends HandlerInterceptorAdapter {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String token = CookieUtil.getCookie("access_token",request);
        System.out.println("token="+token);
        if(StringUtils.isEmpty(token)){
            System.out.println("没有登录！");
            response.setCharacterEncoding("UTF-8");
//            response.setHeader("contentType","text/html; charset=utf-8");
            response.setContentType("text/html; charset=utf-8");
            PrintWriter printWriter = response.getWriter();
            printWriter.write("没有登录！aaaaa");
            printWriter.flush();
            printWriter.close();
            return false;
        }else{
            Claims claims = JwtTokenUtils.parseToken(token);
            System.out.println(claims.get("name"));
        }
        return super.preHandle(request, response, handler);
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        super.postHandle(request, response, handler, modelAndView);
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        super.afterCompletion(request, response, handler, ex);
    }
}
