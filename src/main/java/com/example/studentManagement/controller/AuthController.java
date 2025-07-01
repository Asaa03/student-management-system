package com.example.studentManagement.controller;

import com.example.studentManagement.model.Role;
import com.example.studentManagement.repository.RoleRepository;
import jakarta.validation.Valid;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import com.example.studentManagement.model.User;
import org.springframework.ui.Model;
import com.example.studentManagement.service.UserService;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.security.Principal;

@Controller
public class AuthController {
    private final UserService userService;

    public AuthController(UserService userService){
        this.userService = userService;
    }


    @GetMapping("/")
    public String login(){
        return "login";
    }

    @GetMapping("/user")
    public String showHome(Model model, Principal principal) {
        User user = userService.findByEmail(principal.getName());
        model.addAttribute("user", user);
        return "home";
    }


    @GetMapping("/user/profile")
    public String userProfile(Model model, @AuthenticationPrincipal UserDetails userDetails) {
        String email = userDetails.getUsername();
        User user = userService.findByEmail(email);
        model.addAttribute("user", user);
        return "profile";
    }


    @GetMapping("/faculty")
    public String faculty(){
        return "faculty/index";
    }

}
