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
    public void
    editProduct(Long id, Product product) {
        Optional<Product> optionalProduct = this.getProductById(id);
        Product p = optionalProduct.get();
        // Setting attributes.
        if (product.getName() != null)
            p.setName(product.getName());
        if (product.getPrice() != null)
            p.setPrice(product.getPrice());
        if (product.getBrand() != null)
            p.setBrand(product.getBrand());
        if (product.getQuantity() != null)
            p.setQuantity(product.getQuantity());

        this.saveProduct(p);
    }

    @Override
    public void deleteProduct(Long id) {
        productRepo.deleteById(id);
    }
}
