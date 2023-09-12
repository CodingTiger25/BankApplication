package com.example.bankapplication.service;

import com.example.bankapplication.repository.UserRepository;
import com.example.bankapplication.user.Role;
import com.example.bankapplication.user.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class UserService implements UserDetailsService {

    //40:00

    @Autowired
    UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;


    public  User registerUser(User user)
    {
        return userRepository.save(user);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        return userRepository.findByUserName(username).orElseThrow(() ->
                new UsernameNotFoundException("User not found"));

        //if(!username.equals("Tiger")) throw new UsernameNotFoundException("Not Tiger");

       /* Set<Role> roles = new HashSet<>();
        roles.add(new Role(1, "USER"));

        return new User(1L, "Tiger", passwordEncoder.encode("pass"),roles);

        /*return (UserDetails) userRepository.findByUserName(username)
                .orElseThrow(() -> new UsernameNotFoundException("User not found"));*/
    }

    public void changeChecking(String name, int amount)
    {
        User user = userRepository.findUserByUserName(name);

        user.setChecking_amount(user.getChecking_amount() +  amount);

        userRepository.save(user);
    }
}


