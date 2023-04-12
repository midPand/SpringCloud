package com.midpand;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * @author minPand
 * @version 1.0
 * @date 2021/7/17 19:58
 */
@EnableEurekaServer
@SpringBootApplication
public class EurekaServer02Application {
    public static void main(String[] args) {
        SpringApplication.run(EurekaServer02Application.class, args);
    }
}
