package com.kitchenware.api.controller;

import com.kitchenware.api.dto.ProductUpdateDTO;
import com.kitchenware.api.entity.Product;
import com.kitchenware.api.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

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

    // Read one product.
    @GetMapping("/{id}")
    public ResponseEntity<Product> getProducById(@PathVariable Long id) {
        Optional<Product> optionalProduct = productService.getProductById(id);
        if (optionalProduct.isEmpty())
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);

        Product product = optionalProduct.get();

        return new ResponseEntity<>(product, HttpStatus.OK);
    }

    // Update a whole product.
    @PutMapping("/edit")
    public ResponseEntity<Product> editProduct(@RequestBody Product product) {
        productService.saveProduct(product);
        return new ResponseEntity<>(product, HttpStatus.OK);
    }

    // Update product by its ID.
    @PutMapping("/edit/{id}")
    public ResponseEntity<Product> editProduct(
        @PathVariable Long id,
        @Validated
        @RequestBody ProductUpdateDTO productUpdateDTO) {

         Optional<Product> optionalProduct = productService.getProductById(id);
         if (optionalProduct.isEmpty())
             return new ResponseEntity<>(HttpStatus.NOT_FOUND);

         productService.editProduct(optionalProduct.get(), productUpdateDTO);
        return new ResponseEntity<>(optionalProduct.get(), HttpStatus.OK);
    }

    // Delete a product by its ID.
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteProduct(Long id) {
        try {
            return new ResponseEntity<>("The product was deleted", HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>("The was an error", HttpStatus.BAD_REQUEST);
        }
    }


}
