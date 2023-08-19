package com.example.bankapplication.service;

import com.example.bankapplication.repository.UserRepository;
import com.example.bankapplication.user.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;


    public  User registerUser(User user)
    {
        return userRepository.save(user);
    }
}


