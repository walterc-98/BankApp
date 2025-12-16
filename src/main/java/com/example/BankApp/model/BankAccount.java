package com.example.BankApp.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Entity
@Getter
@Setter
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public abstract class BankAccount {

    @Id
    @Column(name="account_id")
    private String id;

    private String name;

    protected BigDecimal balance;

    protected BankAccount() {}

    protected BankAccount(String id, String name) {
        this.id = id;
        this.name = name;
        this.balance = BigDecimal.ZERO;
    }

}
