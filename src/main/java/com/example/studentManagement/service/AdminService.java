package com.example.studentManagement.service;

import com.example.studentManagement.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class AdminService {


    private final UserRepository userRepository;

    public AdminService(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    public Map<String, Long> getRoleCount(){
        Map<String, Long> count = new HashMap<>();
        count.put("admin", userRepository.countByRole("ROLE_ADMIN"));
        count.put(("faculty"), userRepository.countByRole("ROLE_FACULTY"));
        count.put(("user"),userRepository.countByRole("ROLE_USER"));
        return count;
    }
}

