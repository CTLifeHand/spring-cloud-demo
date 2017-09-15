package com.zml.springcloud.demo;

import org.springframework.amqp.core.Queue;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

/**
 * Created with IntelliJ IDEA.
 * User: zhumeilu
 * Date: 2017/8/3
 * Time: 15:51
 * To change this template use File | Settings | File Templates.
 */
@SpringBootApplication
public class Application {
    @Bean
    public Queue helloQueue() {
        return new Queue("hello");
    }
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
