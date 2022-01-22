package com.acaglar.accountexample.dto;

import com.acaglar.accountexample.models.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDto {
    private long id;
    private String name;
    private List<AccountDto> accounts;
    private List<TransactionDto> transactions;

    public UserDto(User user) {
        this.name = user.getName();
    }
}
