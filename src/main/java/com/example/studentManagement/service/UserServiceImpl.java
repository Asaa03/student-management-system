package com.example.studentManagement.service;

import com.example.studentManagement.model.Role;
import com.example.studentManagement.model.User;
import com.example.studentManagement.repository.RoleRepository;
import com.example.studentManagement.repository.UserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final RoleRepository roleRepository;

    public UserServiceImpl (PasswordEncoder passwordEncoder, UserRepository userRepository, RoleRepository roleRepository){
        this.passwordEncoder = passwordEncoder;
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
    }
    @Override
    public User saveUser(User user) {
        if (userRepository.findByEmail(user.getEmail()) != null) {
            throw new IllegalArgumentException("Email already registered");
        }
        Role role = roleRepository.findByRoleName("ROLE_USER");
        user.setRoles(Arrays.asList(role));
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return userRepository.save(user);
    }

    @Override
    public User findByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public User updateUserDetails(Long id, User updatedUser) {
        User existing = userRepository.findById(id).orElse(null);
        if (existing != null) {
            existing.setUserName(updatedUser.getUserName());
            existing.setEmail(updatedUser.getEmail());
            existing.setSemester(updatedUser.getSemester());
            existing.setAddress(updatedUser.getAddress());
            existing.setNumber(updatedUser.getNumber());
            return userRepository.save(existing); // return the updated user
        }
        return null; // in case user not found
    }

    @Override
    public User deleteUserById(Long id) {
        User user = userRepository.findById(id).orElse(null);
        if (user != null) {
            user.getRoles().clear();
            userRepository.deleteById(id);
        }
        return user;
    }


}
