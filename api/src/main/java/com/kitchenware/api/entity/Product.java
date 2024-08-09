package com.kitchenware.api.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Setter @Getter
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long productID;
    private String name;
    private String brand;
    private Double price;
    private Integer quantity;
    @ManyToMany(mappedBy = "productList")
    private List<Sell> sellList;
    public Product() {
    }

    public Product(String brand, String name, Double price, int quantity) {
        this.brand = brand;
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }
}
