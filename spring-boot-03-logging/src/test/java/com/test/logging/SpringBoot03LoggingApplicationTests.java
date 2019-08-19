package com.test.logging;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringBoot03LoggingApplicationTests {

    Logger logger = LoggerFactory.getLogger(getClass());

    @Test
    public void contextLoads() {
    }

    @Test
    public void loggingTest(){
        logger.trace("。。。。。这是TRACE信息");
        logger.debug("------------debug信息");
        logger.info("这是INFO级别信息");
        logger.warn("------------warn信息");
        logger.error("------------error信息");
    }

}
