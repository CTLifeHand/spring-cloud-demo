package com.zml.springcloud.demo.controller;

import com.zml.springcloud.demo.service.ConsumerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.function.Consumer;

/**
 * Created with IntelliJ IDEA.
 * User: zhumeilu
 * Date: 2017/7/10
 * Time: 16:13
 * To change this template use File | Settings | File Templates.
 */
@RestController
public class ConsumeController {


    @Autowired
    private ConsumerService consumerService;
    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public String add() {
        return consumerService.add();
    }
}
