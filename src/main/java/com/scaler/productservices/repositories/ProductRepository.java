package com.scaler.productservices.repositories;

import com.scaler.productservices.models.Product;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
//Product Repo should contain all the methods (CRUD) related to Product model.

    @Override
    Optional<Product> findById(Long id);
    List<Product> findByPriceIsGreaterThan(Double price);
//    List<Product> findByName(String word);
    List<Product> findByPrice(Double price);
    @Override
    List<Product> findAll(Sort sort);

    //select * from products where price > ?

    List<Product> findProductByTitleLike(String word); // case sensitive
    //select * from products where title like '%iphone%'

    List<Product> findByTitleLikeIgnoreCase(String word); // case insensitive.

    List<Product> findTop5ByTitleContains(String word);
    //select * from products where title like '' LIMIT 5

//    List<Product> findTopByTitleContains(int top, String word);

    List<Product> findProductsByTitleContainsAndPriceGreaterThan(
            String word,
            Double price
    );

    List<Product> findProductsByTitleContainsOrderById(String word);


}


