package com.acaglar.accountexample.service.impl;

import com.acaglar.accountexample.constants.AccountType;
import com.acaglar.accountexample.dto.AccountDto;
import com.acaglar.accountexample.models.Account;
import com.acaglar.accountexample.models.User;
import com.acaglar.accountexample.repository.AccountRepository;
import com.acaglar.accountexample.service.AccountService;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class AccountServiceImpl implements AccountService {
    private final AccountRepository accountRepository;

    public AccountServiceImpl(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    public void create(User user) {
        createAccount(user, AccountType.CREDIT);
        createAccount(user, AccountType.DEBIT);
    }

    public AccountDto createAccount(User user, AccountType accountType){
        Account creditAccount = new Account();
        creditAccount.setAccountType(accountType);
        creditAccount.setUser(user);
        creditAccount.setLimit(BigDecimal.ZERO);
        creditAccount.setBalance(BigDecimal.ZERO);
        Account createdAccount  = accountRepository.save(creditAccount);
        return new AccountDto(createdAccount);
    }
}
