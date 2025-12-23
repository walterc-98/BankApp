package com.example.BankApp.model;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class Account {
    private Long id;
    private String accountNumber;
    private BigDecimal balance;
    private String status;
    private String customerId;
}
