package com.test.springboothelloworld;

import com.test.springboothelloworld.DTO.Person;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringBootHelloworldApplicationTests {

    @Autowired
    Person person ;

    @Autowired
    ApplicationContext applicationContext ;

    @Test
    public void testApplication(){
       Boolean flag =  applicationContext.containsBean("helloService");
       System.out.println(flag);
    }
    @Test
    public void contextLoads() {
        System.out.println(person);
    }

}
