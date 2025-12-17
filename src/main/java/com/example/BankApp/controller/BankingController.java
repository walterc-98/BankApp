package com.example.BankApp.controller;

import com.example.BankApp.model.CheckingAccount;
import com.example.BankApp.service.BankingService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
}
