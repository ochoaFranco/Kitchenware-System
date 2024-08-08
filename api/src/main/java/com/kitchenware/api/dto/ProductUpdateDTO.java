package com.kitchenware.api.dto;

import lombok.Data;

import java.io.Serializable;

@Data
public class ProductUpdateDTO implements Serializable {
    private String brand;
    private String name;
    private Double price;
    private Integer quantity;

    public ProductUpdateDTO() {
    }

    public ProductUpdateDTO(String brand, String name, Double price, Integer quantity) {
        this.brand = brand;
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }

}
