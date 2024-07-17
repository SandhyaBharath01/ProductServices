package com.scaler.productservices.service;

import com.scaler.productservices.exceptions.ProductNotFoundException;
import com.scaler.productservices.models.Product;
import com.scaler.productservices.repositories.CategoryRepository;
import com.scaler.productservices.repositories.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service("selfProductService")
public class SelfProductService implements ProductService{
    private ProductRepository productRepository;
    private CategoryRepository categoryRepository;

    public SelfProductService(ProductRepository productRepository, CategoryRepository categoryRepository){
        this.productRepository = productRepository;
        this.categoryRepository = categoryRepository;
    }
    @Override
    public Product getSingleProduct(Long productId) throws ProductNotFoundException {
//        return null;
        Optional<Product> productOptional = productRepository.findById(productId);
        if(productOptional.isEmpty()){
            throw new ProductNotFoundException("product id with " +productId + "not found");
        }
        return productOptional.get();
    }

    @Override
    public List<Product> getAllProducts() {
//        return List.of();
        return productRepository.findAll();
    }

    @Override
    public Product updateProduct(Long id, Product product) {
        return null;
    }

    @Override
    public Product replaceProduct(Long id, Product product) {
        return null;
    }
}
