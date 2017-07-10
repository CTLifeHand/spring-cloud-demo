package com.zml.springcloud.demo.service;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Created with IntelliJ IDEA.
 * User: zhumeilu
 * Date: 2017/7/10
 * Time: 16:37
 * To change this template use File | Settings | File Templates.
 */
@FeignClient(value = "compute-service", fallback = ConsumerrServiceHystrix.class)   //指定服务不可用调用的类
@Service
public interface ConsumerService {

    @RequestMapping(method = RequestMethod.GET, value = "/add")
    Integer add(@RequestParam(value = "a") Integer a, @RequestParam(value = "b") Integer b);

}
