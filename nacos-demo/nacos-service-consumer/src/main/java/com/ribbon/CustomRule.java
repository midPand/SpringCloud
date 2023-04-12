package com.ribbon;

import com.alibaba.nacos.client.naming.utils.ThreadLocalRandom;
import com.netflix.client.config.IClientConfig;
import com.netflix.loadbalancer.AbstractLoadBalancerRule;
import com.netflix.loadbalancer.ILoadBalancer;
import com.netflix.loadbalancer.Server;
import org.springframework.context.annotation.Configuration;

import java.util.List;

/**
 * @author minPand
 * @version 1.0
 * @date 2021/7/26 20:36
 */
@Configuration
public class CustomRule extends AbstractLoadBalancerRule {



    public Server choose(Object o) {

        ILoadBalancer loadBalancer = this.getLoadBalancer();

        //获取当前请求的服务的实例
        List<Server> reachableServers = loadBalancer.getReachableServers();

        int i = ThreadLocalRandom.current().nextInt(reachableServers.size());

        Server server = reachableServers.get(i);

        return server;
    }

    public void initWithNiwsConfig(IClientConfig iClientConfig) {

    }




}
