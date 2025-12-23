package com.example.BankApp.repository;

import com.example.BankApp.model.BankTransaction;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface TransactionMapper {
    int insert(BankTransaction bankTransaction);

    List<BankTransaction> findByAccountId(@Param("accountId") Long accountId,
                                          @Param("limit") int limit,
                                          @Param("offset") int offset);
}
