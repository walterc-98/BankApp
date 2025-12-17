package com.example.BankApp.service;

import com.example.BankApp.model.CheckingAccount;

import java.math.BigDecimal;

public interface BankingService {

    void createAccount(CheckingAccount checkingAccount);

    void deposit(String accountId, BigDecimal amount);

    void withdraw(String accountId, BigDecimal amount);

    BigDecimal getBalance(String accountId);
}
