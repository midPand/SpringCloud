package com.midpand.controller;

import com.midpand.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author minPand
 * @version 1.0
 * @date 2021/7/17 21:00
 */
@RestController
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private ProductService productService;


    @GetMapping("/list")
    public List getProductList(){
        return productService.getProductList();
    }
}
