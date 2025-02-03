package com.example.demo.controller;

import com.example.demo.entity.Product;
import com.example.demo.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/products")
public class ProductController {

    @Autowired
    private ProductService productService;

    @PutMapping("/update/{productId}/{quantity}")
    public Product updateInventoryStock(@PathVariable Integer productId,
                                        @PathVariable Integer quantity) {
        return productService.updateProductQuantity(productId, quantity);
    }

    @GetMapping("total_price/{productId}")
    public Double getTotalPrice(@PathVariable Integer productId){
        System.out.println("getTotalPrice called instantly");
        return productService.calculateProductPrice(productId);
    }
}
