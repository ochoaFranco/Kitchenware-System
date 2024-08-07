package com.kitchenware.api.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@Entity
@Setter @Getter
public class Sell {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long sellID;
    private LocalDate sellDate;
    private Double total;
    private List<Product> productList;
    private Client client;

    public Sell() {
    }

    public Sell(Client client, List<Product> productList, LocalDate sellDate, Double total) {
        this.client = client;
        this.productList = productList;
        this.sellDate = sellDate;
        this.total = total;
    }
}
