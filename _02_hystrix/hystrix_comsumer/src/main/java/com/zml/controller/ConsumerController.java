package com.zml.controller;

import com.zml.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * Created by zhumeilu on 17/9/15.
 */
@RestController
public class ConsumerController {

    @Autowired
    private CustomerService customerService;

    @GetMapping("/custom")
    public String custom(){

        return customerService.custom();

    }
}
