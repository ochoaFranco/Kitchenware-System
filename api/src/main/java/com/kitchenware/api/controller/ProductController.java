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

    // Read one product.
    @GetMapping("/get/{id}")
    public ResponseEntity<Product> getProducById(Long id) {
        Product product = productService.getProductById(id);
        if ( product == null) {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(product, HttpStatus.OK);
    }

    // Update a whole product.
    @PutMapping("/edit")
    public ResponseEntity<Product> editProduct(@RequestBody Product product) {
        productService.saveProduct(product);
        return new ResponseEntity<>(product, HttpStatus.OK);
    }
//        this.brand = brand;
//        this.name = name;
//        this.price = price;
//        this.quantity = quantity;
    @PutMapping("/edit/{id}")
    public ResponseEntity<Product> editProduct(@PathVariable Long id, @RequestParam(required = false) String brand,
                                               @RequestParam(required = false) String name,
                                               @RequestParam(required = false) Double price,
                                               @RequestParam(required = false) Integer quantity) {

        Product product = productService.getProductById(id);
        if (product == null)
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        if (brand != null)
            product.setBrand(brand);
        if (name != null)
            product.setName(name);
        if (price != null)
            product.setPrice(price);
        if (quantity != null)
            product.setQuantity(quantity);
        productService.editProduct(id, name, brand, price, quantity);
        return new ResponseEntity<>(product, HttpStatus.OK);
    }




}
