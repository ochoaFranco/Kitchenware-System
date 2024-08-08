package com.kitchenware.api.service;

import com.kitchenware.api.dto.ProductUpdateDTO;
import com.kitchenware.api.entity.Product;
import com.kitchenware.api.repository.IProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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
    public Optional<Product> getProductById(Long id) {
        return productRepo.findById(id);
    }

    // Update a whole product.
    @Override
    public void editProduct(Product product) {
        this.saveProduct(product);
    }

    // Update part of a product.
    @Override
    public void editProduct(Product product, ProductUpdateDTO productUpdateDTO) {
        if (productUpdateDTO.getBrand() != null)
            product.setBrand(productUpdateDTO.getBrand());
        if (productUpdateDTO.getName() != null)
            product.setName(productUpdateDTO.getName());
        if (productUpdateDTO.getPrice() != null)
            product.setPrice(productUpdateDTO.getPrice());
        if (productUpdateDTO.getQuantity() != null)
            product.setQuantity(productUpdateDTO.getQuantity());
    }

    @Override
    public void deleteProduct(Long id) {
        productRepo.deleteById(id);
    }
}
