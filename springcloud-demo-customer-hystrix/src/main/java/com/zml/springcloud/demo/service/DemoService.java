package com.zml.springcloud.demo.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 * Created with IntelliJ IDEA.
 * User: zhumeilu
 * Date: 2017/8/2
 * Time: 17:38
 * To change this template use File | Settings | File Templates.
 */
@Service
public class DemoService {
    @Autowired
    RestTemplate restTemplate;

    @HystrixCommand(fallbackMethod = "fallback")
    public String hello(){
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return restTemplate.getForObject("http://eureka-client/hello",String.class);
    }
    public String fallback(){
        return "fallback";
    }
}
