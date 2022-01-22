package com.acaglar.accountexample.models;

import com.acaglar.accountexample.dto.UserDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="Users", indexes = @Index(columnList = "name"))
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;
    @OneToMany
    private List<Account> accounts;
    @OneToMany
    private List<Transaction> transactions;

    public User(UserDto userDto) {
        this.name = userDto.getName();
    }
}
