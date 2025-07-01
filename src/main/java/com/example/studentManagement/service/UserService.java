package com.example.studentManagement.service;

import com.example.studentManagement.model.User;
import org.springframework.stereotype.Service;

import java.util.List;

public interface UserService {
    User saveUser(User user);

    User findByEmail(String email);

    List<User> getAllUsers();

    User updateUserDetails(Long id, User updatedUser);
    User deleteUserById(Long id);
}

