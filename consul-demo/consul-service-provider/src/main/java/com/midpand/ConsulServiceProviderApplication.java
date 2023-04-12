package com.midpand;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author minPand
 * @version 1.0
 * @date 2021/7/20 22:10
 */
@SpringBootApplication
@EnableDiscoveryClient
public class ConsulServiceProviderApplication {
    public static void main(String[] args) {
        SpringApplication.run(ConsulServiceProviderApplication.class,args);
    }
}
