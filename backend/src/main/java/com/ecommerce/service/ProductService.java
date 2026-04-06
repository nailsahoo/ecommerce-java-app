package com.ecommerce.service;

import com.ecommerce.model.Product;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductService {

    public List<Product> getAllProducts() {
        List<Product> products = new ArrayList<>();

        products.add(new Product(1, "iPhone 14", "Electronics", 80000));
        products.add(new Product(2, "T-Shirt", "Clothing", 500));
        products.add(new Product(3, "Java Book", "Books", 300));
        products.add(new Product(4, "Washing Machine", "Home Appliances", 20000));
        products.add(new Product(5, "Rice Bag", "Groceries", 1000));

        return products;
    }
}
