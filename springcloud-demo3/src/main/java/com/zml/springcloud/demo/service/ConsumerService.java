package com.zml.springcloud.demo.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 * Created with IntelliJ IDEA.
 * User: zhumeilu
 * Date: 2017/7/10
 * Time: 17:40
 * To change this template use File | Settings | File Templates.
 */
@Service
public class ConsumerService {

    @Autowired
    RestTemplate restTemplate;

    @HystrixCommand(fallbackMethod = "addFallback") //指定服务降级方法
    public String add(){
        return restTemplate.getForEntity("http://COMPUTE-SERVICE/add?a=10&b=20", String.class).getBody();
    }

    public String addFallback(){
        return "error";
    }
}
