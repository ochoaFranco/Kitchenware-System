package com.kitchenware.api.entity;

import jakarta.persistence.*;
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
    @ManyToMany
    @JoinTable(
            name = "sell_product",
            joinColumns = @JoinColumn(name = "sell_id"),
            inverseJoinColumns = @JoinColumn(name = "product_id")
    )
    private List<Product> productList;
    @OneToOne
    @JoinColumn(name = "sellClientID", referencedColumnName = "clientID")
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
