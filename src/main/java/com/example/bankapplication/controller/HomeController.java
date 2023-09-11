package com.example.bankapplication.controller;

import com.example.bankapplication.repository.UserRepository;
import com.example.bankapplication.service.UserService;
import com.example.bankapplication.user.User;
import com.example.bankapplication.user.UserCheckingDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@CrossOrigin("*")
@RequestMapping("/user")
public class HomeController {

    @Autowired
    private UserRepository userRepository;


    @Autowired
    UserService userService;

    /*@GetMapping("/")
    public String home()
    {
        return "home-page";
    }*/


    @PutMapping("/checking")
    public void checking(@RequestBody UserCheckingDTO body)
    {
        userService.changeChecking(body.getUserName(), body.getChecking_amount());
    }
}
