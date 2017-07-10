package com.zml.springcloud.demo;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

/**
 * Created with IntelliJ IDEA.
 * User: zhumeilu
 * Date: 2017/7/10
 * Time: 15:25
 * To change this template use File | Settings | File Templates.
 */
@SpringBootApplication
@EnableDiscoveryClient  //发现服务能力
@EnableFeignClients
@EnableCircuitBreaker   //开启断路器
public class Application {


    public static void main(String[] args) {
        new SpringApplicationBuilder(Application.class).web(true).run(args);
    }
}
