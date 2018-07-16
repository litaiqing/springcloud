package com.springcloud.test.hystrix;

import com.springcloud.test.feign.SchedualServiceHi;
import org.springframework.stereotype.Component;

/**
 * Description:
 * <br/>
 *
 * @author litaiqing
 * @version 1.0
 * @date: 2018/7/16 17:41
 * @since JDK 1.8
 */
@Component
public class SchedualServiceHiHystrix implements SchedualServiceHi {

    @Override
    public String sayHiFromClientOne(String name) {
        return "sorry, hystrix " + name;
    }
}
