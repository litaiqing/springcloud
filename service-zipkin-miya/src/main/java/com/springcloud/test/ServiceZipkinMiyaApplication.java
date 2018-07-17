package com.springcloud.test;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * Description:
 * <br/>
 *
 * @author litaiqing
 * @version 1.0
 * @date: 2018/7/17 15:47
 * @since JDK 1.8
 */
@SpringBootApplication
@RestController
public class ServiceZipkinMiyaApplication {


    public static void main(String[] args) {
        SpringApplication.run(ServiceZipkinMiyaApplication.class, args);
    }

    private static final Logger logger = LoggerFactory.getLogger(ServiceZipkinMiyaApplication.class);

    @Autowired
    private RestTemplate restTemplate;

    @RequestMapping("/hi")
    public String home() {
        logger.info("hi is being called");
        return "hi i'm miya !";
    }


    @RequestMapping("/miya")
    public String info(){
        logger.info("info is being called");
        return restTemplate.getForObject("http://localhost:8988/info", String.class);
    }

    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }


}
