package com.springcloud.test;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;

/**
 * Description:
 * <br/>
 *
 * @author litaiqing
 * @version 1.0
 * @date: 2018/7/16 17:19
 * @since JDK 1.8
 */
@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
public class FeginServiceApplication {


    public static void main(String[] args) {
        SpringApplication.run(FeginServiceApplication.class, args);
    }


}
