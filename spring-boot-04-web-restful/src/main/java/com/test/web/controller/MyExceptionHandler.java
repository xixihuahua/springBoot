package com.test.web.controller;

import com.test.web.exception.UserNotExistException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

/**
 * description
 *
 * @author 24360 2019/08/30 10:07
 */
@ControllerAdvice
public class MyExceptionHandler {

   // 没有自适应效果，浏览器/客户端返回的都是json
  /*  @ResponseBody
    @ExceptionHandler(UserNotExistException.class)
    public Map<String,Object> handlerException(Exception e){
        Map<String,Object> map = new HashMap<>();
        map.put("code" , "user not exits");
        map.put("message" , "用户不存在呐");
        return map;
    }*/

   @ExceptionHandler(UserNotExistException.class)
   public String handlerException(Exception e, HttpServletRequest request){
       Map<String,Object> map = new HashMap<>();
        request.setAttribute( "javax.servlet.error.status_code",500 );
       map.put("code" , "user not exits");
       map.put("message" , "用户不存在呐");
       request.setAttribute("ext",map);
       return "forward:/error";
   }
}
