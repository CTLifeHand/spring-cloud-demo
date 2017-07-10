package com.zml.springcloud.demo;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * Created with IntelliJ IDEA.
 * User: zhumeilu
 * Date: 2017/7/10
 * Time: 16:18
 * To change this template use File | Settings | File Templates.
 */
@SpringBootApplication
@EnableEurekaServer
public class Application {

    public static void main(String[] args) {
        new SpringApplicationBuilder(Application.class).web(true).run(args);
    }
}
