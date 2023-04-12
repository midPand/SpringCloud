package com.midpand;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;


/**
 * @author minPand
 * @version 1.0
 * @date 2021/7/17 19:58
 */
@SpringBootApplication
@EnableDiscoveryClient
public class ConsulServiceConsumerApplication {
    @LoadBalanced
    @Bean
    public RestTemplate restTemplate(){
        return new RestTemplate();
    }
    public static void main(String[] args) {
        SpringApplication.run(ConsulServiceConsumerApplication.class, args);
    }
}
