package com.acaglar.accountexample.models;

import com.acaglar.accountexample.constants.AccountType;
import com.acaglar.accountexample.dto.AccountDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="Accounts", indexes = @Index(columnList = "user, accountType"))
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private AccountType accountType;
    private BigDecimal limit;
    private BigDecimal balance;
    @ManyToOne
    private User user;

    public Account(AccountDto accountDto){
        this.accountType = accountDto.getAccountType();
        this.limit = accountDto.getLimit();
        this.balance = accountDto.getBalance();
        this.user = new User(accountDto.getUser());
    }
}
