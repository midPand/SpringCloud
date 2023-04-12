package com.midpand.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

/**
 * @author minPand
 * @version 1.0
 * @date 2021/7/17 21:27
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Order implements Serializable {
    private Integer id;
    private String  orderNo;
    private String orderAddress;
    private Double totalPrice;
    private List<Product> productList;
}
