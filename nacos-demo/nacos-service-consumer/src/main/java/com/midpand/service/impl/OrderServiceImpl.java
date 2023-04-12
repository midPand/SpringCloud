package com.midpand.service.impl;

import com.midpand.pojo.Order;
import com.midpand.pojo.Product;
import com.midpand.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
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
        return new Order(id, "order-001", "中国", 54D, getProductListByRestTemplate());
    }



    //restTemplate 远程获取商品List
    private List<Product> getProductListByRestTemplate() {
        List<Product> list = restTemplate.getForObject("http://nacos-service-provide/product/list", List.class);
        return list;
    }


//    public Order getOrder(Integer id) {
//        return new Order(id, "order-001", "中国", 54D, getProductListByRestTemplate());
//    }
}
