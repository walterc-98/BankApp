package com.example.BankApp.service;

import com.example.BankApp.model.BankAccount;
import com.example.BankApp.model.CheckingAccount;
import com.example.BankApp.repository.BankAccountRepository;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class BankingServiceImpl implements BankingService{

    private final BankAccountRepository bankAccountRepository;

    public BankingServiceImpl(BankAccountRepository bankAccountRepository) {
        this.bankAccountRepository = bankAccountRepository;
    }

    @Override
    public void createAccount(CheckingAccount checkingAccount) {
        bankAccountRepository.save(checkingAccount);
    }

    @Override
    public void deposit(Long accountId, BigDecimal amount) {
        BankAccount bankAccount = bankAccountRepository.findById(accountId)
                .orElseThrow(()-> new IllegalArgumentException("Account not found"));
        bankAccount.deposit(amount);
        bankAccountRepository.save(bankAccount);
    }

    @Override
    public void withdraw(Long accountId, BigDecimal amount) {
        BankAccount bankAccount= bankAccountRepository.findById(accountId)
                .orElseThrow(()-> new IllegalArgumentException("Account not found"));
        bankAccount.withdraw(amount);
        bankAccountRepository.save(bankAccount);
    }

    @Override
    public BigDecimal getBalance(Long accountId) {
        BankAccount bankAccount = bankAccountRepository.findById(accountId)
                .orElseThrow(()-> new IllegalArgumentException("Account not found"));
        return bankAccount.getBalance();
    }
}
