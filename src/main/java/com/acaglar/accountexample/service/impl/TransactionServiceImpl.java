package com.acaglar.accountexample.service.impl;

import com.acaglar.accountexample.dto.TransactionDto;
import com.acaglar.accountexample.models.Account;
import com.acaglar.accountexample.models.Transaction;
import com.acaglar.accountexample.models.User;
import com.acaglar.accountexample.repository.TransactionRepository;
import com.acaglar.accountexample.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Service
public class TransactionServiceImpl implements TransactionService {

    private final TransactionRepository transactionRepository;

    @Autowired
    public TransactionServiceImpl(TransactionRepository transactionRepository) {
        this.transactionRepository = transactionRepository;
    }

    public TransactionDto create(User user, Account account, BigDecimal amount){
        Transaction newTransaction = new Transaction();
        newTransaction.setAccount(account);
        newTransaction.setAmount(amount);
        newTransaction.setUser(user);
        newTransaction.setTransactionTime(LocalDateTime.now());
        Transaction createdTransaction = transactionRepository.save(newTransaction);
        return new TransactionDto(createdTransaction);
    }
}
