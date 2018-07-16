package com.springcloud.test.feign;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Description:
 * <br/>
 *
 * @author litaiqing
 * @version 1.0
 * @date: 2018/7/16 17:25
 * @since JDK 1.8
 */
@FeignClient(value = "service-hi")
public interface SchedualServiceHi {

    @RequestMapping(value = "/hi", method = RequestMethod.GET)
    public String sayHiFromClientOne(@RequestParam(value = "name") String name);

}
