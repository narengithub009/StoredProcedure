package com.example.demo.service;

import com.example.demo.entity.Product;
import com.example.demo.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;
    public Product updateProductQuantity(Integer productId, Integer quantity){
        productRepository.stockUpdate(productId,quantity);
        return productRepository.findById(productId).get();
    }

    public  Double calculateProductPrice(int id){
        double price=0.0;
        for (int i = 0; i <=50 ; i++) {
          price = productRepository.getTotalPrice(id);
        }
        return price;
    }
}
