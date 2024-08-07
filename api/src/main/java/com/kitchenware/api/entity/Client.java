package com.kitchenware.api.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Entity
@Setter @Getter
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long clientID;
    private String name;
    private String lastname;
    private String identification;

    public Client() {
    }

    public Client(String identification, String lastname, String name) {
        this.identification = identification;
        this.lastname = lastname;
        this.name = name;
    }
}

