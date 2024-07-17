package com.scaler.productservices.service;

import com.scaler.productservices.exceptions.ProductNotFoundException;
import com.scaler.productservices.models.Product;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import  java.util.List;

@Service("selfProductService")
public interface ProductService {

//    Product getSingleProduct(Long productId);
    //Exception Handling
    Product getSingleProduct(Long productId) throws ProductNotFoundException;
    List<Product> getAllProducts();
    Product updateProduct(Long id, Product product);
    Product replaceProduct(Long id, Product product);
}
