package com.midpand;

import com.netflix.loadbalancer.RandomRule;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;


/**
 * @author minPand
 * @version 1.0
 * @date 2021/7/17 19:58
 */
@SpringBootApplication
//@EnableEurekaClient  //新版本 默认开启
public class ServiceConsumerApplication {
    @Bean
//    @LoadBalanced  //负载均衡
    public RestTemplate restTemplate(){
        return  new RestTemplate();
    }

//  基于注解的随机策略
//    @Bean
//    public RandomRule randomRule(){
//        return new RandomRule();
//    }
    public static void main(String[] args) {
        SpringApplication.run(ServiceConsumerApplication.class, args);
    }
}
