package com.springcloud.test;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Description:
 * <br/>
 *
 * @author litaiqing
 * @version 1.0
 * @date: 2018/7/17 11:39
 * @since JDK 1.8
 */
@SpringBootApplication
@RestController
public class ConfigClientApplication {

    public static void main(String[] args) {

        SpringApplication.run(ConfigClientApplication.class, args);

    }

    @Value("${foo}")
    private String foo;


    @RequestMapping("/hi")
    public String hi() {
        return foo;
    }


}
