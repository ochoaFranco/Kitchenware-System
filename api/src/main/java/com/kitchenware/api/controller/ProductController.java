package com.kitchenware.api.controller;

import com.kitchenware.api.entity.Product;
import com.kitchenware.api.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {
    @Autowired
    private IProductService productService;

    // Create a product.
    @PostMapping("/create")
    public ResponseEntity<Product> saveProduct(@RequestBody Product product) {
        productService.saveProduct(product);
        return new ResponseEntity<>(product, HttpStatus.CREATED);
    }

    // Read all products.
    @GetMapping()
    public ResponseEntity<List<Product>> getProducts() {
        List<Product> productList = productService.getProducts();
        return new ResponseEntity<>(productList, HttpStatus.OK);
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<Product> getProducById(Long id) {
        Product product = productService.getProductById(id);
        if ( product == null) {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(product, HttpStatus.OK);
    }


}
