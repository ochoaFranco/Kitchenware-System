package com.kitchenware.api.service;

import com.kitchenware.api.dto.ProductUpdateDTO;
import com.kitchenware.api.entity.Product;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

public interface IProductService {
    // Create method.
    void saveProduct(Product product);

    // get all products.
    List<Product> getProducts();

    // get one product.
    Optional<Product> getProductById(Long id);

    // update a whole product.
    void editProduct(Product product);

    // update part of a product.
    void editProduct(Product product, ProductUpdateDTO productUpdateDTO);

    // delete one product by id.
    void deleteProduct(Long id);
}
