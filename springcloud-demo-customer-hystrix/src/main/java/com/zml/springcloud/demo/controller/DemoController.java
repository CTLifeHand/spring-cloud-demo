package com.zml.springcloud.demo.controller;

import com.zml.springcloud.demo.service.DemoService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * Created with IntelliJ IDEA.
 * User: zhumeilu
 * Date: 2017/8/1
 * Time: 14:29
 * To change this template use File | Settings | File Templates.
 */
@RestController
public class DemoController {

    Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private DemoService demoService;
    @Autowired
    RestTemplate restTemplate;

        @GetMapping("/hello")
        public String hello2(){
            return demoService.hello();
        }


}
