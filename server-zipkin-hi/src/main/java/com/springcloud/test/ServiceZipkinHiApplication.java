package com.springcloud.test;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.sleuth.sampler.AlwaysSampler;
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
 * @date: 2018/7/17 15:41
 * @since JDK 1.8
 */
@SpringBootApplication
@RestController
public class ServiceZipkinHiApplication {


    public static void main(String[] args) {

        SpringApplication.run(ServiceZipkinHiApplication.class, args);

    }


    private static final Logger logger = LoggerFactory.getLogger(ServiceZipkinHiApplication.class);

    @Autowired
    private RestTemplate restTemplate;


    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }

    @RequestMapping("/hi")
    public String callHome() {
        logger.info("calling hi trace service-zipkin-hi !!");

        return restTemplate.getForObject("http://localhost:8989/miya", String.class);
    }

    @RequestMapping("/info")
    public String info() {
        logger.info("calling info trace service-zipkin-hi !!");
        return "i'm service-zipkin-hi";
    }


    @Bean
    public AlwaysSampler alwaysSampler() {
        return new AlwaysSampler();
    }



}
