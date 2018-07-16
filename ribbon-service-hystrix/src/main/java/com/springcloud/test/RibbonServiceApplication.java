package com.springcloud.test;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

/**
 * Description:
 * <br/>
 *
 * @author litaiqing
 * @version 1.0
 * @date: 2018/7/16 16:21
 * @since JDK 1.8
 */
@SpringBootApplication
@EnableDiscoveryClient
@EnableHystrix
@EnableHystrixDashboard
public class RibbonServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(RibbonServiceApplication.class, args);
    }


    @Bean
    @LoadBalanced
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }

}
