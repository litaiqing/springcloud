package com.springcloud.test;

import com.springcloud.test.filter.MyFilter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.annotation.Bean;

/**
 * Description:
 * <br/>
 *
 * @author litaiqing
 * @version 1.0
 * @date: 2018/7/16 18:07
 * @since JDK 1.8
 */
@EnableZuulProxy
@EnableEurekaClient
@SpringBootApplication
public class ServiceZuulApplication {

    private static final Logger logger = LoggerFactory.getLogger(ServiceZuulApplication.class);

    public static void main(String[] args) {

        SpringApplication.run(ServiceZuulApplication.class, args);

    }

    @Bean
    @ConditionalOnMissingBean
    public MyFilter myFilter() {
        logger.info("init MyFilter...");
        return new MyFilter();
    }

}
