package com.test.springboothelloworld.controller;

import com.test.springboothelloworld.DTO.Person;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * description
 *
 * @author 24360 2019/08/14 15:14
 */
//这个类的所有方法的返回数据直接写给浏览器(如果是对象能直接转为json)
/*@ResponseBody
@Controller*/
@RestController
public class HelloController {

    @Value("${person.last-name}")
    private String name ;

    @RequestMapping("/hello")
    public String hello(){
        return "hello world ! " ;
    }

    @RequestMapping("/person/{age}/{lastName}")
    public Person hello( @PathVariable("age") int age , @PathVariable("lastName") String lastName){
        Person person = new Person();
        person.setAge(age);
        person.setLastName(lastName);
        return person ;
    }

    @RequestMapping("/sayHello")
    public String sayHello(){
            return "hello" + name ;
    }

}
