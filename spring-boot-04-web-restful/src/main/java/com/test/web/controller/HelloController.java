package com.test.web.controller;

import com.test.web.exception.UserNotExistException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Map;

/**
 * description
 *
 * @author 24360 2019/08/19 16:40
 */
@Controller
public class HelloController {

   /* @RequestMapping({"/" , "/index.html"})
    public String index(){
        return "index" ;
    }*/

/*
    @ResponseBody
    @RequestMapping("/hello")
    public String hello(){
        return "hello world ! " ;
    }*/

    @ResponseBody
    @RequestMapping("/hello")
    public  String hello(@RequestParam("user") String user){
        if(user.equals("aaa")){
            throw new UserNotExistException();
        }
        return "Hello World";
    }


    @RequestMapping("/success")
    public String success( Map<String,Object> map){
        map.put("name" , "嘻嘻花花");
        return "success";
    }
}
