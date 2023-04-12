package com.midpand.controller;

import com.midpand.pojo.Order;
import com.midpand.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author minPand
 * @version 1.0
 * @date 2021/7/17 21:00
 */
@RestController
@RequestMapping("/order")
public class OrderController {

    @Autowired
    private OrderService orderService;


    @GetMapping("/get/{id}")
    public Order getOrder(@PathVariable("id") Integer id){

        return orderService.getOrder(id);
    }
}
