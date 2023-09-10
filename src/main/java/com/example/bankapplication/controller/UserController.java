package com.example.bankapplication.controller;

import com.example.bankapplication.repository.UserRepository;
import com.example.bankapplication.user.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;
import java.util.Optional;


@RestController
@RequestMapping("/user")
@CrossOrigin("*")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/")
    public Optional<User> helloUserController(Principal principal){

        return userRepository.findByUserName(principal.getName());


        //return principal.getName();
    }
}
