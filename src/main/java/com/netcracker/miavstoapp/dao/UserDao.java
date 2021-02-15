package com.netcracker.miavstoapp.dao;

import com.netcracker.miavstoapp.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;


public interface UserDao extends JpaRepository<User, Long> {
    User findByUsername(String username);
}


