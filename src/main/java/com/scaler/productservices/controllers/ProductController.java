package com.scaler.productservices.controllers;

import com.scaler.productservices.models.Product;
import com.scaler.productservices.service.ProductService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import  java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {
    //Declaration and injection of Product service
    private ProductService productService;

    //Constructor
    public ProductController(ProductService productService){
        this.productService = productService;
    }
    @GetMapping("/{id}")
    public Product getProductById(@PathVariable("id") Long id){
        return productService.getSingleProduct(id);
    }
    @GetMapping()
    public List<Product> getAllProducts(){
        return productService.getAllProducts();
    }
}
