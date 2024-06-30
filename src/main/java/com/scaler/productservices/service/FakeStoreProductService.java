package com.scaler.productservices.service;

import com.scaler.productservices.dtos.FakeStoreProductDto;
import org.springframework.stereotype.Service;
import com.scaler.productservices.models.Category;
import com.scaler.productservices.models.Product;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Service
public class FakeStoreProductService implements ProductService{
    private RestTemplate restTemplate;

    public FakeStoreProductService(RestTemplate restTemplate){
        this.restTemplate = restTemplate;
    }
    @Override
    public Product getSingleProduct(Long productId){
        FakeStoreProductDto fakeStoreProductDto = restTemplate.getForObject(
                "https://fakestoreapi.com/products/" + productId,
                FakeStoreProductDto.class
        );
        return convertFakeStoreProductToProduct(fakeStoreProductDto);
    }
    @Override
    public List<Product> getAllProducts(){
        FakeStoreProductDto[] fakeStoreProductDtos = restTemplate.getForObject(
               "https://fakestoreapi.com/products",
                FakeStoreProductDto[].class
        );
        //Convert List of FakeStoreProductDto into List of Product.
        List<Product> products = new ArrayList<>();
        for(FakeStoreProductDto fakeStoreProductDto : fakeStoreProductDtos){
            products.add(convertFakeStoreProductToProduct(fakeStoreProductDto));
        }
        return products;
    }

    private Product convertFakeStoreProductToProduct(FakeStoreProductDto fakeStoreProductDto){
        Product product = new Product();
        product.setId(fakeStoreProductDto.getId());
        product.setTitle(fakeStoreProductDto.getTitles());
        product.setPrice(fakeStoreProductDto.getPrice());

        Category category = new Category();
        category.setDescription(fakeStoreProductDto.getCategory());
        product.setCategory(category);
        return product;
    }
}
