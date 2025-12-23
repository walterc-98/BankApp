package com.example.BankApp.controller;

import com.example.BankApp.service.BankingService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;

@RestController
@RequestMapping("/api/v1/accounts")
public class BankingController {

    private final BankingService bankingService;

    public BankingController(BankingService bankingService) {
        this.bankingService = bankingService;
    }

    @PostMapping("/create")
    public ResponseEntity<Void> create(@RequestBody CheckingAccount checkingAccount){
        bankingService.createAccount(checkingAccount);
        System.out.println("Account created for " + checkingAccount.getName() + " with id " + checkingAccount.getId());
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @PutMapping("/{id}/deposit")
    public ResponseEntity<Void> deposit(@PathVariable Long id, @RequestParam BigDecimal amount){
        bankingService.deposit(id,amount);
        System.out.println("Deposited " + amount + " to account " + id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @PutMapping("/{id}/withdraw")
    public ResponseEntity<Void> withdraw(@PathVariable Long id, @RequestParam BigDecimal amount){
        bankingService.withdraw(id,amount);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @GetMapping("/{id}/balance")
    public ResponseEntity<BigDecimal> balance(@PathVariable Long id){
        BigDecimal balance = bankingService.getBalance(id);
        return ResponseEntity.ok(balance);
    }
}
