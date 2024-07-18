package com.scaler.productservices.service;

import com.scaler.productservices.exceptions.ProductNotFoundException;
import com.scaler.productservices.models.Category;
import com.scaler.productservices.models.Product;
import com.scaler.productservices.repositories.CategoryRepository;
import com.scaler.productservices.repositories.ProductRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
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
    public Product updateProduct(Long id, Product product) throws ProductNotFoundException{
//        return null;
        Product existingProduct = productRepository.findById(product.getId()).get();
        existingProduct.setTitle(product.getTitle());
        existingProduct.setCategory(product.getCategory());
        existingProduct.setPrice(product.getPrice());

        Category category = product.getCategory();
        if(category.getId()==null){
            category = categoryRepository.save(category);
        }
        existingProduct.setCategory(category);
        return productRepository.save(product);
    }

    @Override
    public Product replaceProduct(Long id, Product product) {
//        return null;
        Product existingProduct = productRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Product with id " + id + " not found"));
        existingProduct.setTitle(product.getTitle());
        existingProduct.setCategory(product.getCategory());
        existingProduct.setPrice(product.getPrice());

        return productRepository.save(existingProduct);
    }
    public void deleteProduct(Long id) {
        productRepository.deleteById(id);
    }
    @Override
    public Product addNewProduct(Product product) {
//        return null;
        Category category = product.getCategory();
        if(category.getId() == null){
            category = categoryRepository.save(category);
            product.setCategory(category);
        }
        return productRepository.save(product);
    }
}
