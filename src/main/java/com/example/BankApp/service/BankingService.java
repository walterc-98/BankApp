package com.example.BankApp.service;

import java.math.BigDecimal;

public interface BankingService {

    void createAccount(BankAccount bankAccount);

    void deposit(Long accountId, BigDecimal amount);

    void withdraw(Long accountId, BigDecimal amount);

    BigDecimal getBalance(Long accountId);
}
