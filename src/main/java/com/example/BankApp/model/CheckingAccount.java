package com.example.BankApp.model;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

@Entity
@DiscriminatorValue("CHECKING")
public class CheckingAccount extends BankAccount {

    public CheckingAccount() {}

    public CheckingAccount(String name) {
        super(name);
        System.out.println("CheckingAccount created for " + name + " and id " + getId());

    }
}
