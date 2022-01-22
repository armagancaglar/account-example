package com.acaglar.accountexample.service;

import com.acaglar.accountexample.constants.AccountType;
import com.acaglar.accountexample.dto.AccountDto;
import com.acaglar.accountexample.models.User;

public interface AccountService {
    void create(User user);
    AccountDto createAccount(User user, AccountType accountType);
}
