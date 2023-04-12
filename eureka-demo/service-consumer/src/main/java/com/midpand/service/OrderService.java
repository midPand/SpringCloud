package com.midpand.service;

import com.midpand.pojo.Order;
import com.midpand.pojo.Product;
import org.aspectj.weaver.ast.Or;

import java.util.List;

/**
 * @author minPand
 * @version 1.0
 * @date 2021/7/17 20:56
 */
public interface OrderService {

    Order getOrder(Integer id);
}
