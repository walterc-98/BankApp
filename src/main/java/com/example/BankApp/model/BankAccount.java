package com.example.BankApp.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Entity
@Getter
@Setter
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="account_type")
public abstract class BankAccount {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="account_id")
    private String id;

    private String name;

    protected BigDecimal balance;

    protected BankAccount() {}

    protected BankAccount(String name) {
        this.name = name;
        this.balance = BigDecimal.ZERO;
    }

    public void deposit(BigDecimal amount){
        if(amount == null || amount.signum() < 0){
            throw new IllegalArgumentException("Amount must be greater than zero");
        }

        this.balance = this.balance.add(amount);
    }

    public void withdraw(BigDecimal amount){
        if(amount == null || amount.signum() < 0){
            throw new IllegalArgumentException("Amount must be greater than zero");
        }

        if (this.balance.compareTo(amount) < 0){
            throw new IllegalArgumentException("Insufficient funds");
        }

        this.balance = this.balance.subtract(amount);
    }

}
