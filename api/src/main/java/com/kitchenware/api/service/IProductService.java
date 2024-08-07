package com.kitchenware.api.service;

import com.kitchenware.api.entity.Product;
import org.springframework.stereotype.Service;

import java.util.List;

public interface IProductService {
    // Create method.
    void saveProduct(Product product);

    // get all products.
    List<Product> getProducts();

    // get one product.
    Product getProductById(Long id);

    // update a whole product.
    void editProduct(Product product);

    // update part of a product.
    boolean editProduct(Long id, String name, String brand, Double price, Integer quantity);

    // delete one product by id.
    void deleteProduct(Long id);
}
