package com.netcracker.miavstoapp.service.impl;


import com.netcracker.miavstoapp.dao.RoleDao;
import com.netcracker.miavstoapp.dao.UserDao;
import com.netcracker.miavstoapp.dto.UserRegistrationDto;
import com.netcracker.miavstoapp.entity.Role;
import com.netcracker.miavstoapp.entity.User;
import com.netcracker.miavstoapp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;
import java.util.Set;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDao userDao;
    @Autowired
    private RoleDao roleDao;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Transactional
    @Override
    public User registerClient(UserRegistrationDto userRegistrationDto) {
        User user = new User();
        user.setUsername(userRegistrationDto.getUsername());
        user.setEmail(userRegistrationDto.getEmail());
        user.setPhoneNumber(userRegistrationDto.getPhoneNumber());
        user.setPassword(bCryptPasswordEncoder.encode(userRegistrationDto.getPassword()));
        Set<Role> roles = new HashSet<>();
        roles.add(roleDao.getOne(1L));
        user.setRoles(roles);
        return userDao.save(user);
    }

    @Override
    public User findByUsername(String username) {
        return userDao.findByUsername(username);
    }
}
