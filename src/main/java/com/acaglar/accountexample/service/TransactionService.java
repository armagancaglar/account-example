package com.acaglar.accountexample.service;

import com.acaglar.accountexample.dto.TransactionDto;
import com.acaglar.accountexample.models.Account;
import com.acaglar.accountexample.models.User;

import java.math.BigDecimal;

public interface TransactionService {
    TransactionDto create(User user, Account account, BigDecimal amount);
}
