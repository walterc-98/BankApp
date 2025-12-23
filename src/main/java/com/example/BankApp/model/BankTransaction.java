package com.example.BankApp.model;

import lombok.Data;

import java.math.BigDecimal;
import java.time.OffsetDateTime;

@Data
public class BankTransaction {
    private Long id;
    private Long accountId;
    private String type;
    private BigDecimal amount;
    private OffsetDateTime createdAt;
}
