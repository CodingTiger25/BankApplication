package com.example.bankapplication.controller;

import com.example.bankapplication.service.UserService;
import com.example.bankapplication.user.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController

public class RegisterController {

    @Autowired
    private UserService userService;

    @CrossOrigin(origins = "http://localhost:8080/")
    @PostMapping("/register")
    public User addUser(@RequestBody User user){

            user.setPassword(new BCryptPasswordEncoder().encode(user.getPassword()));

            return userService.registerUser(user);
    }

}
