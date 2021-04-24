package com.test.mongodb.repository;

import com.test.mongodb.entity.Product;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends MongoRepository<Product, String> {
    public List<Product> findByProductName(String productName);
}
