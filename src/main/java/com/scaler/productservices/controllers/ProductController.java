package com.scaler.productservices.controllers;

import com.scaler.productservices.exceptions.ProductNotFoundException;
import com.scaler.productservices.models.Product;
import com.scaler.productservices.service.ProductService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import  java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {
    //Declaration and injection of Product service
    private ProductService productService;

    //Constructor
    public ProductController(@Qualifier("selfProductService") ProductService productService){
        this.productService = productService;
    }
//    @GetMapping("/{id}")
//    public Product getProductById(@PathVariable("id") Long id){
//        return productService.getSingleProduct(id);
//    }
//    Exception Handling
    @GetMapping("/{id}")
    public ResponseEntity<Product> getProductById(@PathVariable("id") Long id) throws ProductNotFoundException {
        ResponseEntity<Product> response = new ResponseEntity<>(
                productService.getSingleProduct(id),
                HttpStatus.OK
        );
        return response;
    }

    @GetMapping()
    public List<Product> getAllProducts(){
        return productService.getAllProducts();
    }
    //Update-Patch
    @PatchMapping ("/{id}")
    public Product updateProduct(@PathVariable("id") Long id, @RequestBody Product product){
        return productService.updateProduct(id, product);
    }

    @PutMapping("/{id}")
    public Product replaceProduct(@PathVariable("id") Long id, @RequestBody Product product){
        return productService.replaceProduct(id, product);
    }
    @DeleteMapping("/{id}")
    public void deleteProduct(@PathVariable("id") Long productId){
        productService.deleteProduct(productId);
    }
    @PostMapping
    public Product addNewProduct(@RequestBody Product product){
        return productService.addNewProduct(product);
    }

}
