package com.example.BankApp.repository;

import com.example.BankApp.model.Account;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.math.BigDecimal;

@Mapper
public interface AccountMapper {
    Account findById(Long id);

    Account findByIdForUpdate(Long id);

    int insert(Account account);

    int updateBalance(@Param("id") Long id, @Param("balance") BigDecimal balance);
}
