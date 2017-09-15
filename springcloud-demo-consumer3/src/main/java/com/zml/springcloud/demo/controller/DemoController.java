package com.zml.springcloud.demo.controller;

import com.zml.springcloud.demo.service.DemoService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: zhumeilu
 * Date: 2017/8/1
 * Time: 14:14
 * To change this template use File | Settings | File Templates.
 */
@RestController
public class DemoController {

    Logger logger = LoggerFactory.getLogger(this.getClass());
    @Autowired
    RestTemplate restTemplate;
    @Autowired
    DemoService demoService;
    @GetMapping("/hello")
    public String hello(){
        logger.info("当前执行方法hello1");
        String ret = demoService.hello();
        logger.info("result:"+ret);
        return ret;
    }

    @GetMapping("/hello2")
    public String hello2(){
        logger.info("当前执行方法hello2");
        String ret = restTemplate.getForObject("http://eureka-client/hello", String.class);
        logger.info("result:"+ret);
        return ret;
    }
}
