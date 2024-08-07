package com.kitchenware.api.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Entity
@Setter @Getter
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long productID;
    private String name;
    private String brand;
    private Double price;
    private int quantity;

    public Product() {
    }

    public Product(String brand, String name, Double price, int quantity) {
        this.brand = brand;
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }
}
