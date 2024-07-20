package com.scaler.productservices.models;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Product extends BaseModel {
    private String title;
    private double price;
//    @ManyToOne(cascade = CascadeType.PERSIST)
//    @ManyToOne(cascade = CascadeType.REMOVE)
@ManyToOne(cascade = CascadeType.ALL)
    private Category category;
}
