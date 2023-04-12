package com.ribbon;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author minPand
 * @version 1.0
 * @date 2021/7/26 20:20
 */
@Configuration
public class RibbonRandomRuleConfig {

    //方法名一定为iRule
    @Bean
    public IRule iRule(){
        return  new RandomRule();
    }
}
