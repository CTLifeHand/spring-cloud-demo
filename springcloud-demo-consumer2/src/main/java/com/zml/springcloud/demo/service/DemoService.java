package com.zml.springcloud.demo.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCollapser;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import com.netflix.hystrix.contrib.javanica.cache.annotation.CacheKey;
import com.netflix.hystrix.contrib.javanica.cache.annotation.CacheRemove;
import com.netflix.hystrix.contrib.javanica.cache.annotation.CacheResult;
import com.zml.springcloud.demo.model.User;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

/**
 * Description:
 * User: zhumeilu
 * Date: 2017/8/24
 * Time: 17:55
 */
@Service
public class DemoService {
    @Autowired
    RestTemplate restTemplate;




    private Long getUserByIdCacheKey(Long id){
        return id;
    }
    @CacheRemove(commandKey = "getUserById")
    @HystrixCommand
    public User update(User user){
        return restTemplate.getForObject("http://eureka-client/update",User.class,user);
    }


    @HystrixCollapser(batchMethod = "batchGetUserByIds",collapserProperties = {
            @HystrixProperty(name="timerDelayInMilliseconds",value="100")
    })
    public User getUserById(Long id){
        return restTemplate.getForObject("http://eureka-client/getUserById?id={1}",User.class,id);
    }
    public List<User> batchGetUserByIds(List<Long> ids){
        return restTemplate.getForObject("http://eureka-client/batchGetUserByIds?ids={1}",List.class, StringUtils.join(ids,","));
    }

//    @HystrixCommand(commandKey = "hello",groupKey = "testGroup",threadPoolKey = "helloThread")
//    public String hello(){
//
//        return restTemplate.getForObject("http://eureka-client/hello",String.class);
//    }
//    public String helloFallback(Throwable e){
//        return "hello";
//    }

//    public String hello(){
//
//       return restTemplate.getForObject("http://eureka-client/hello",String.class);
//    }
//    @HystrixCommand(fallbackMethod = "helloDefaultFallback")
//    public String helloFallback(){
//        return restTemplate.getForObject("http://eureka-client/hello2",String.class);
//    }
//
//    public String helloDefaultFallback(){
//        return "hello";
//    }
//    @HystrixCommand
//    public Future<String> helloAsync(){
//
//        return new AsyncResult<String>() {
//            @Override
//            public String invoke() {
//                return restTemplate.getForObject("http://eureka-client/hello",String.class);
//            }
//        };
//    }
}
