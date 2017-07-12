package com.zml.springcloud.demo.service;

import org.springframework.stereotype.Component;

/**
 * Created with IntelliJ IDEA.
 * User: zhumeilu
 * Date: 2017/7/10
 * Time: 17:35
 * To change this template use File | Settings | File Templates.
 */
@Component
public class ConsumerrServiceHystrix implements ConsumerService {

    @Override
    public Integer add(Integer a, Integer b) {
        return -9999;
    }
}
