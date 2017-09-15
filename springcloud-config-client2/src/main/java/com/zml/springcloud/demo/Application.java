package com.zml.springcloud.demo;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * Created with IntelliJ IDEA.
 * User: zhumeilu
 * Date: 2017/7/11
 * Time: 11:43
 * To change this template use File | Settings | File Templates.
 */
@EnableDiscoveryClient
@SpringBootApplication
public class Application {

        public static void main(String[] args) {
            new SpringApplicationBuilder(Application.class).web(true).run(args);
        }

}
