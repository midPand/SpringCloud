package com.midpand;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


/**
 * @author minPand
 * @version 1.0
 * @date 2021/7/17 19:58
 */
@SpringBootApplication
//@EnableEurekaClient  //新版本 默认开启
public class ServiceProvider02Application {
    public static void main(String[] args) {
        SpringApplication.run(ServiceProvider02Application.class, args);
    }
}
