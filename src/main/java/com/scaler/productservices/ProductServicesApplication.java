package com.scaler.productservices;

import com.scaler.productservices.models.Product;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ProductServicesApplication {

    public static void main(String[] args) {
        SpringApplication.run(ProductServicesApplication.class, args);

        Product product = new Product();
        product.setTitle("iPhone 15");
    }

}
