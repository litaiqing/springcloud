package com.springcloud.test;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Description:
 * <br/>
 *
 * @author litaiqing
 * @version 1.0
 * @date: 2018/7/17 15:41
 * @since JDK 1.8
 */
@SpringBootApplication
@RestController
@EnableDiscoveryClient
public class ServiceHiApplication {


    public static void main(String[] args) {

        SpringApplication.run(ServiceHiApplication.class, args);

    }

    private static final Logger logger = LoggerFactory.getLogger(ServiceHiApplication.class);

    @RequestMapping("/hi")
    public String callHome() {
        logger.info("calling hi trace service-hi !!");
        return "hi";
    }



}
