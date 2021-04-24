package com.test.mongodb.entity;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document
public class Product {

    @Id
    String productID;

    String productName;

    String productCategory;

    double productPrice;

}
