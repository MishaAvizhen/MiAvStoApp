package com.netcracker.miavstoapp.service;

import com.netcracker.miavstoapp.dto.UserRegistrationDto;
import com.netcracker.miavstoapp.entity.User;

import java.util.List;


public interface UserService {

    User registerClient(UserRegistrationDto userRegistrationDto);

    User findByUsername(String username);

}
