package com.midpand.service.impl;

import com.midpand.pojo.Order;
import com.midpand.pojo.Product;
import com.midpand.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.web.client.RestTemplate;

import java.util.List;

/**
 * @author minPand
 * @version 1.0
 * @date 2021/7/17 20:57
 */
@Service
public class OrderServiceImpl implements OrderService {
    @Autowired
    private RestTemplate restTemplate;


    //源数据
    @Autowired
    private DiscoveryClient discoveryClient;

    //Ribbon 负载均衡器
    @Autowired
    private LoadBalancerClient loadBalancerClient;


    @Override
    public Order getOrder(Integer id) {
//        return new Order(id, "order-001", "中国", 54D, getProductListByDiscoveryClient());
        return new Order(id, "order-001", "中国", 54D, getProductListByLoadBalancerClient());
//        return new Order(id, "order-001", "中国", 54D, getProductListByLoadBalancerClientAnnotation());
    }


    //源数据方式获取 商品List
    private List<Product> getProductListByDiscoveryClient() {
        StringBuffer stringBuffer = null;
        //获取服务列表
        List<String> services = discoveryClient.getServices();
        if (CollectionUtils.isEmpty(services)) {
            return null;
        }
        //根据服务名称获取服务
        List<ServiceInstance> serviceInstances = discoveryClient.getInstances("service-provider");
        if (CollectionUtils.isEmpty(serviceInstances)) {
            return null;
        }

        ServiceInstance serviceInstance = serviceInstances.get(0);
        stringBuffer = new StringBuffer();

        stringBuffer.append("http://" + serviceInstance.getHost() + ":" + serviceInstance.getPort() + "/product/list");
        ResponseEntity<List<Product>> exchange = restTemplate.exchange(
                stringBuffer.toString(),
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<List<Product>>() {
                });

        return exchange.getBody();
    }


    //Ribbon负载均衡器换区 商品List
    private List<Product> getProductListByLoadBalancerClient() {
        StringBuffer stringBuffer = null;

        //根据服务名称获取服务
        ServiceInstance serviceInstance = loadBalancerClient.choose("service-provider");

        if (serviceInstance == null) {
            return null;
        }
        stringBuffer = new StringBuffer();

        stringBuffer.append("http://" + serviceInstance.getHost() + ":" + serviceInstance.getPort() + "/product/list");
        System.out.println(stringBuffer.toString());
        ResponseEntity<List<Product>> exchange = restTemplate.exchange(
                stringBuffer.toString(),
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<List<Product>>() {
                });

        return exchange.getBody();
    }

    //Ribbon负载均衡器获取 注解 商品List    restTemplate @LoadBalanced  注解
    private List<Product> getProductListByLoadBalancerClientAnnotation() {
        ResponseEntity<List<Product>> exchange = restTemplate.exchange(
                "http://service-provider/product/list",
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<List<Product>>() {
                });
        return exchange.getBody();
    }


}
