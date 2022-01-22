package com.acaglar.accountexample.dto;


import com.acaglar.accountexample.models.Transaction;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

 import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TransactionDto {
    private long id;
    private AccountDto account;
    private UserDto user;
    private BigDecimal amount;
    private LocalDateTime transactionTime;

    public TransactionDto(Transaction transaction){
        this.id = transaction.getId();
        this.account = new AccountDto(transaction.getAccount());
        this.user = new UserDto(transaction.getUser());
        this.amount = transaction.getAmount();
        this.transactionTime = transaction.getTransactionTime();
    }
}