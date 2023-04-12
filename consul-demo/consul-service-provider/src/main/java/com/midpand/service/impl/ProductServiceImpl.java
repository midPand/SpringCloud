package com.midpand.service.impl;


import com.midpand.pojo.Product;
import com.midpand.service.ProductService;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;


/**
 * @author minPand
 * @version 1.0
 * @date 2021/7/17 20:57
 */
@Service
public class ProductServiceImpl  implements ProductService {
    @Override
    public List<Product> getProductList() {
        return Arrays.asList(
          new Product(1,"华为",2,5188D),
          new Product(2,"苹果",3,2688D),
          new Product(3,"小米",5,3288D)
        );
    }
}
