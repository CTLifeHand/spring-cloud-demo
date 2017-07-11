package com.zml.springcloud.demo.service;

import com.ctc.wstx.util.InternCache;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: zhumeilu
 * Date: 2017/7/10
 * Time: 17:40
 * To change this template use File | Settings | File Templates.
 */
@Service
public class ConsumerService {

    Logger logger = LoggerFactory.getLogger(ConsumerService.class);
    @Autowired
    RestTemplate restTemplate;

    @HystrixCommand(fallbackMethod = "addFallback") //指定服务降级方法
    public String add(){
        logger.info("进入add方法。。。。");
//        Map map = new HashMap<String,String>();
//        map.put("a","1");
//        map.put("b","2");
//        String forObject = restTemplate.getForObject("http://compute-service/add", String.class, map);
//        logger.info("计算结果："+forObject);
        return restTemplate.getForEntity("http://COMPUTE-SERVICE/add?a=10&b=20", String.class).getBody();
    }

    public String addFallback(){
        return "error";
    }

    @HystrixCommand(fallbackMethod = "addFallback2") //指定服务降级方法
    public String add2(){
        logger.info("进入add2方法。。。。");
        Map map = new HashMap<String,Integer>();
        map.put("a",1);
        map.put("b",2);
        String s = restTemplate.postForObject("http://COMPUTE-SERVICE/add2?a={a}&b={b}", null, String.class, map);
        logger.info("计算结果："+s);
        return s;
    }

    public String addFallback2(){
        return "error";
    }
}
