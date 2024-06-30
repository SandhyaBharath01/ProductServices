package com.scaler.productservices.service;

import com.scaler.productservices.models.Product;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import  java.util.List;

public interface ProductService {

    Product getSingleProduct(Long productId);
    List<Product> getAllProducts();
}
