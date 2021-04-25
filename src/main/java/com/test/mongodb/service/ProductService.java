package com.test.mongodb.service;

import com.test.mongodb.entity.Product;
import com.test.mongodb.entity.ProductResponse;
import com.test.mongodb.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    public Product saveProduct(Product product)
    {
        product.setProductID(UUID.randomUUID().toString().replace("-", ""));
        return productRepository.save(product);
    }

    public List<Product> saveProducts(List<Product> products)
    {
        products.stream().forEach(product -> {product.setProductID(UUID.randomUUID().toString().replace("-", ""));});
        return productRepository.saveAll(products);
    }

    public List<Product> getAllProducts()
    {
        return productRepository.findAll();
    }

    public ProductResponse getProductById(String id)
    {
        Optional<Product> product = productRepository.findById(id);
        if(product.isPresent())
            return new ProductResponse(Collections.singletonList(product.get()), null);
        else
            return new ProductResponse(null, id+" NOT FOUND");
    }

    public ProductResponse getProductByProductName(String productName)
    {
        List<Product> productList = productRepository.findByProductName(productName);
        if(productList != null && productList.size() > 0)
            return new ProductResponse(productList, null);
        else
            return new ProductResponse(null, productName+ " NOT FOUND");

    }

    public ProductResponse deleteProduct(String id)
    {
        productRepository.deleteById(id);
        return new ProductResponse(null, "PRODUCT DELETED "+id);
    }

}
