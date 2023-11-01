package com.banksultra.finalproject.services;

import com.banksultra.finalproject.models.User;

import java.util.List;

public interface UserService {
    User signUp(User user);
    List<User> findAll();
    User findById(Long id);
    User updateData(Long id, User user);
}
