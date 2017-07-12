package com.zml.springcloud.demo.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created with IntelliJ IDEA.
 * User: zhumeilu
 * Date: 2017/7/12
 * Time: 14:36
 * To change this template use File | Settings | File Templates.
 */
@RefreshScope
@RestController
public class PropController {

    @Value("${from}")
    private String from;
    @RequestMapping("/from")
    public String from() {
        return this.from;
    }
}
