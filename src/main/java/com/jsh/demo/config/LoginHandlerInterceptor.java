package com.jsh.demo.config;

import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 登录请求拦截器
 */
public class LoginHandlerInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        // 首先获取session值，没有session值则需要重新登录，这里的session在登录成功后会塞入用户名
        Object loginUser = request.getSession().getAttribute("loginUser");
        if(loginUser == null){ // 没有登录
            request.setAttribute("msg", "没有权限，请先登录！");
            // 重定向到登录页
            request.getRequestDispatcher("/index").forward(request, response);
            return false;
        }else{
            return true;
        }
    }
}
