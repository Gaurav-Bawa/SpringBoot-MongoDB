package com.test.mongodb.resource;

import com.test.mongodb.service.ProductService;
import com.test.mongodb.entity.Product;
import com.test.mongodb.entity.ProductResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

@RestController
public class ProductResource {

    @Autowired
    private ProductService productService;

    @PostMapping("/product/saveProduct")
    public Product saveProduct(@RequestBody Product product)
    {
        return productService.saveProduct(product);
    }

    @PostMapping("/product/saveProducts")
    public List<Product> saveProduct(@RequestBody List<Product> products)
    {
        return productService.saveProducts(products);
    }

    @GetMapping("/product/all")
    public List<Product> getAllProduct()
    {
        return productService.getAllProducts();
    }

    @GetMapping("/product/{id}")
    public ProductResponse getProductById(@PathVariable String id)
    {
        return productService.getProductById(id);
    }

    @GetMapping("/product/name")
    public ProductResponse getProductByName(@RequestParam HashMap<String, String> map)
    {
        return productService.getProductByProductName(map.get("name"));
    }

    @DeleteMapping("/product/{id}")
    public ProductResponse deleteProduct(@PathVariable String id)
    {
        return productService.deleteProduct(id);
    }
}
