package com.midpand;

import com.ribbon.RibbonRandomRuleConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.netflix.ribbon.RibbonClients;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;


/**
 * @author minPand
 * @version 1.0
 * @date 2021/7/17 19:58
 */
@SpringBootApplication
//@RibbonClients(value = {
//        @RibbonClient(name="nacos-service-provide",configuration = RibbonRandomRuleConfig.class)
//})
public class NacosServiceConsumerApplication {

    @Bean
    @LoadBalanced
    public RestTemplate restTemplate(){
        return new RestTemplate();
    }
    public static void main(String[] args) {
        SpringApplication.run(NacosServiceConsumerApplication.class, args);
    }
}
