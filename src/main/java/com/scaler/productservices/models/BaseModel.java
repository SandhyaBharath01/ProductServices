package com.scaler.productservices.models;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@MappedSuperclass
public class BaseModel {
    @Id//PK
    @GeneratedValue(strategy = GenerationType.IDENTITY)//Auto-Increment
    private long id;
    private Date created_at;
    private Date updated_at;
}
