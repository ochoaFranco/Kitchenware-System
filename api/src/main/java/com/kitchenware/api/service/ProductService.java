package com.kitchenware.api.service;

import com.kitchenware.api.entity.Product;
import com.kitchenware.api.repository.IProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService implements IProductService {
    @Autowired
    IProductRepository productRepo;

    // Create Method.
    @Override
    public void saveProduct(Product product) {
        productRepo.save(product);
    }
    // Read all products.
    @Override
    public List<Product> getProducts() {
        return productRepo.findAll();
    }

    // Read one product.
    @Override
    public Product getProductById(Long id) {
        return productRepo.findById(id).orElse(null);
    }

    // Update a whole product.
    @Override
    public void editProduct(Product product) {
        this.saveProduct(product);
    }

    // Update part of a product.
    @Override
    public boolean editProduct(Long id, String newName, String newBrand, Double newPrice, int newQuantity) {
        Product product = this.getProductById(id);
        if (product == null)
            return false;
        product.setName(newName);
        product.setBrand(newBrand);
        product.setPrice(newPrice);
        product.setQuantity(newQuantity);
        return true;
    }

    @Override
    public void deleteProduct(Long id) {
        productRepo.deleteById(id);
    }
}
