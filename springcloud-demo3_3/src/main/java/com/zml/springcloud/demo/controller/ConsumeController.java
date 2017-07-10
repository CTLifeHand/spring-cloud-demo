package com.zml.springcloud.demo.controller;

import com.zml.springcloud.demo.service.ConsumerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

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
    ConsumerService consumerService;

    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public Integer add() {
        return consumerService.add(10,10);
    }
}
