package com.test.web.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * description
 *
 * @author 24360 2019/08/19 16:40
 */
@RestController
public class HelloController {

    @RequestMapping("/hello")
    public String hello(){
        return "hello world ! " ;
    }

}
