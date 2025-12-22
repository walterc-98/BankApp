package com.example.BankApp.service;

import com.example.BankApp.exception.InvalidAmountException;
import com.example.BankApp.model.BankAccount;
import com.example.BankApp.model.CheckingAccount;
import com.example.BankApp.repository.BankAccountRepository;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class BankingServiceImpl implements BankingService{

    private final BankAccountRepository bankAccountRepository;

    public BankingServiceImpl(BankAccountRepository bankAccountRepository) {
        this.bankAccountRepository = bankAccountRepository;
    }

    @Override
    public void createAccount(BankAccount checkingAccount) {
        bankAccountRepository.save(checkingAccount);
    }

    @Override
    @Transactional
    public void deposit(Long accountId, BigDecimal amount) {
        validateAmount(amount);
        BankAccount bankAccount = bankAccountRepository.findById(accountId)
                .orElseThrow(()-> new IllegalArgumentException("Account not found"));
        bankAccount.deposit(amount);
        bankAccountRepository.save(bankAccount);
        System.out.println("Deposited to account " + accountId + ". Version: " + bankAccount.getVersion());
    }

    @Override
    @Transactional
    public void withdraw(Long accountId, BigDecimal amount) {
        validateAmount(amount);
        BankAccount bankAccount= bankAccountRepository.findById(accountId)
                .orElseThrow(()-> new IllegalArgumentException("Account not found"));
        bankAccount.withdraw(amount);
        bankAccountRepository.save(bankAccount);
        System.out.println("Withdraw to account " + accountId + ". Version: " + bankAccount.getVersion());
    }

    @Override
    @Transactional(readOnly = true)
    public BigDecimal getBalance(Long accountId) {
        BankAccount bankAccount = bankAccountRepository.findById(accountId)
                .orElseThrow(()-> new IllegalArgumentException("Account not found"));
        return bankAccount.getBalance();
    }

    private static void validateAmount(BigDecimal amount) {
        if(amount == null) throw new InvalidAmountException("Amount cannot be null");
        if(amount.signum() < 0) throw new InvalidAmountException("Amount cannot be negative");
        if(amount.scale() > 2) throw new InvalidAmountException("Amount cannot have more than 2 decimal places");
    }
}
