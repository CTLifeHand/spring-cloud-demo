package com.zml.springcloud.demo.service;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * Created with IntelliJ IDEA.
 * User: zhumeilu
 * Date: 2017/8/1
 * Time: 16:28
 * To change this template use File | Settings | File Templates.
 */
@FeignClient("eureka-client")
public interface DemoService {

    @GetMapping("/hello")
    String hello();
}
