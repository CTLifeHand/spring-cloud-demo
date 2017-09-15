package com.zml.springcloud.demo.controller;

import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
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
    LoadBalancerClient loadBalancerClient;

    @Autowired
    RestTemplate restTemplate;
    @GetMapping("/hello")
    public String hello(){
        ServiceInstance serviceInstance = loadBalancerClient.choose("eureka-client");
        logger.info("host:"+serviceInstance.getHost()+"---port:"+serviceInstance.getPort()+"---uri"+serviceInstance.getUri());
        String url = "http://"+serviceInstance.getHost()+":"+serviceInstance.getPort()+"/hello";
        String ret = null;
        OkHttpClient client = new OkHttpClient();
//        String forObject = restTemplate.getForObject(url, String.class);
        Request request = new Request.Builder()
                .url(url)
                .build();
        try{
            Response response = client.newCall(request).execute();
            ret = response.body().string();
            System.out.println(ret);
        }catch (Exception e){
            e.printStackTrace();
        }
        return ret;
    }

}
