package com.midpand.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @author minPand
 * @version 1.0
 * @date 2021/7/17 20:54
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Product implements Serializable {

    private Integer id;
    private String productMame;
    private Integer productNum;
    private Double productPrice;
}
