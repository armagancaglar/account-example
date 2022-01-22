package com.acaglar.accountexample.service.impl;

import com.acaglar.accountexample.dto.UserDto;
import com.acaglar.accountexample.models.User;
import com.acaglar.accountexample.repository.UserRepository;
import com.acaglar.accountexample.service.UserService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public UserDto createUser(UserDto userDto){
        if(userDto == null && StringUtils.isBlank(userDto.getName())){
            throw new IllegalArgumentException("User name can not be null!");
        }
        User newUser = userRepository.save(new User(userDto));
        return new UserDto(newUser);
    }

    @Override
    public UserDto updateUser(UserDto userDto) {
        UserDto foundDto = getById(userDto.getId());
        foundDto.setName(userDto.getName());

        User userToUpdate = new User(foundDto);

        userRepository.save(userToUpdate);

        return new UserDto(userToUpdate);
    }

    @Override
    public UserDto getById(Long id) {
        User foundUser = userRepository.getById(id);
        return new UserDto(foundUser);
    }
}
