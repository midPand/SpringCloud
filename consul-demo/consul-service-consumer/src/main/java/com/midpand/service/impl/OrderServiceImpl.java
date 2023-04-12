package com.midpand.service.impl;

import com.midpand.pojo.Order;
import com.midpand.pojo.Product;
import com.midpand.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
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
    @Override
    public Order getOrder(Integer id) {
        return new Order(id, "order-001", "中国", 54D, getProductListByLoadBalancerClientAnnotation());
    }
    //Ribbon负载均衡器获取 注解 商品List    restTemplate @LoadBalanced  注解
    private List<Product> getProductListByLoadBalancerClientAnnotation() {
        ResponseEntity<List<Product>> exchange = restTemplate.exchange(
                "http://consul-service-provide/product/list",
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<List<Product>>() {
                });
        return exchange.getBody();
    }




}
