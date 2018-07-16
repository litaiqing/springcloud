package com.springcloud.test.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 * Description:
 * <br/>
 *
 * @author litaiqing
 * @version 1.0
 * @date: 2018/7/16 16:34
 * @since JDK 1.8
 */
@Service
public class HelloService {


    @Autowired
    private RestTemplate restTemplate;

    @HystrixCommand(fallbackMethod = "hiError")
    public String hiService(String name) {
        return restTemplate.getForObject("http://SERVICE-HI/hi?name=" + name, String.class);
    }


    public String hiError(String name) {
        return "hi, " + name + ", sorry, error";
    }

}
