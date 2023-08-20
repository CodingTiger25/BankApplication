package com.example.bankapplication.controller;


import com.example.bankapplication.repository.UserRepository;
import com.example.bankapplication.user.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginController {

    //private UserService userService;

    @Autowired
    private final UserRepository userRepository;



    public LoginController(UserRepository userRepository)
    {
        this.userRepository = userRepository;
    }

    //@CrossOrigin(origins = "http://localhost:8080/")
    @GetMapping("/login")
    public User getUser(@RequestParam Integer id)
    {
        return userRepository.findById(id);
    }

}
