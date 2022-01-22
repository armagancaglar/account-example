package com.acaglar.accountexample.service;

import com.acaglar.accountexample.dto.UserDto;

public interface UserService {
    UserDto createUser(UserDto userDto);
    UserDto updateUser(UserDto userDto);
    UserDto getById(Long id);
}
