package com.acaglar.accountexample.models;


import com.acaglar.accountexample.dto.AccountDto;
import com.acaglar.accountexample.dto.TransactionDto;
import com.acaglar.accountexample.dto.UserDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="Transactions", indexes = @Index(columnList = "account, user"))
public class Transaction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @ManyToOne
    private Account account;
    @ManyToOne
    private User user;
    private BigDecimal amount;
    private LocalDateTime transactionTime;

    public Transaction(TransactionDto transactionDto){
        this.id = transactionDto.getId();
        this.account = new Account(transactionDto.getAccount());
        this.user = new User(transactionDto.getUser());
        this.amount = transactionDto.getAmount();
        this.transactionTime = transactionDto.getTransactionTime();
    }
}
