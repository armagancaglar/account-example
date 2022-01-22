package com.acaglar.accountexample.dto;

import com.acaglar.accountexample.constants.AccountType;
import com.acaglar.accountexample.models.Account;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AccountDto {
    private long id;
    private AccountType accountType;
    private BigDecimal limit;
    private BigDecimal balance;
    private UserDto user;

    public AccountDto(Account account){
        this.accountType = account.getAccountType();
        this.limit = account.getLimit();
        this.balance = account.getBalance();
        this.user = new UserDto(account.getUser());
    }

}