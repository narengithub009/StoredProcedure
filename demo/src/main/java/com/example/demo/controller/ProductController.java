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
        Product product=new Product();
        for (int i = 0; i <=1000 ; i++) {
            product = productService.updateProductQuantity(productId, quantity);
        }
        return product;
    }

    @GetMapping("total_price/{productId}")
    public Double getTotalPrice(@PathVariable Integer productId){
        double price=0.0;
        for (int i = 0; i <=1000 ; i++) {
            price = productService.calculateProductPrice(productId);
        }


        return price;
    }
}
