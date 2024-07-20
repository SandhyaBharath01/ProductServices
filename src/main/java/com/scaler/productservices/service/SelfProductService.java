package com.scaler.productservices.service;


import com.scaler.productservices.exceptions.ProductNotFoundException;
import com.scaler.productservices.models.Category;
import com.scaler.productservices.models.Product;
import com.scaler.productservices.repositories.CategoryRepository;
import com.scaler.productservices.repositories.ProductRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service("selfProductService")
public class SelfProductService implements ProductService {
    private ProductRepository productRepository;
    private CategoryRepository categoryRepository;

    public SelfProductService(ProductRepository productRepository,
                              CategoryRepository categoryRepository) {
        this.productRepository = productRepository;
        this.categoryRepository = categoryRepository;
    }

    @Override
    public Product getSingleProduct(Long productId) throws ProductNotFoundException {
        // Make a call to DB to fetch a product with given id.
        Optional<Product> productOptional = productRepository.findById(productId);

        if (productOptional.isEmpty()) {
            throw new ProductNotFoundException("Product with id: " + productId + " doesn't exist");
        }

        return productOptional.get();
    }

    @Override
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    //PATCH
    @Override
    public Product updateProduct(Long id, Product product) throws ProductNotFoundException {
        Optional<Product> optionalProduct = productRepository.findById(id);

        if (optionalProduct.isEmpty()) {
            throw new ProductNotFoundException("Product with id : " + id + " doesn't exist");
        }

        Product productInDB = optionalProduct.get();

        if (product.getTitle() != null) {
            productInDB.setTitle(product.getTitle());
        }


        return productRepository.save(productInDB);
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
    @Override
    public void deleteProduct(Long id) {
        productRepository.deleteById(id);
    }

    @Override
    public Product addNewProduct(Product product) {
        Category category = product.getCategory();

//        if (category.getId() == null) {
//            // We need to create a new Category object in the DB first.
//            category = categoryRepository.save(category);
//            product.setCategory(category);
//        }

        return productRepository.save(product);
    }
}