package com.example.userservice.service;


import com.example.userservice.entity.UserEntity;
import com.example.userservice.model.dto.UserDto;

public interface UserService {
    UserDto createUser(UserDto userDto);

    UserDto getUserByUserId(String userId);

    Iterable<UserEntity> getUserByAll();

    UserDto getUserDetailsByEmail(String userName);
}
