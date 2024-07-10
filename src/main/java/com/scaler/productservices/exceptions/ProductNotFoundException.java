package com.scaler.productservices.exceptions;

public class ProductNotFoundException extends Exception{
    private Long id;
    public ProductNotFoundException(String message){
        super(message);
    }
    public ProductNotFoundException(Long id) {
        super("Product not found: " + id);
        this.id = id;
    }

    public Long getProductId() {
        return id;
    }
}
