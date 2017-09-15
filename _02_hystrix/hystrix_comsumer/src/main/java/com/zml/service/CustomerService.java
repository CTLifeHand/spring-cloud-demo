package com.zml.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.client.RestTemplate;

/**
 * Created by zhumeilu on 17/9/15.
 */
@Service
public class CustomerService {



    @Autowired
    private RestTemplate restTemplate;


    @HystrixCommand(fallbackMethod = "customFallback")
    public String custom(){

//        try {
//            Thread.sleep(5000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
        String forObject = restTemplate.getForObject("http://provider-service/hello", String.class);
        return forObject;

    }

    public String customFallback(){

        return "error";
    }
}
