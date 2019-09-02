package com.test.web.component;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * description 登录检查
 *
 * @author 24360 2019/08/28 10:54
 */
public class LoginHandlerInterceptor implements HandlerInterceptor {

    //目标方法执行前
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
       Object user =  request.getSession().getAttribute("loginUser") ;
       if(user == null){
           // 没有登录则返回登录界面，并提示没有权限
           request.setAttribute("msg" , "没有登录权限");
           request.getRequestDispatcher("/index.html").forward(request,response);
           return false;
       }else{
           //已登录则放行
           return true ;
       }

    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }
}
