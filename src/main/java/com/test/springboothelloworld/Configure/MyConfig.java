package com.test.springboothelloworld.Configure;

import com.test.springboothelloworld.service.HelloService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * description
 *
 * @author 24360 2019/08/15 15:59
 */
@Configuration
public class MyConfig {

    @Bean
    public Object helloService1(){
        return new HelloService();
    }

}
