package com.example.bankapplication.service;

import com.example.bankapplication.repository.RoleRespository;
import com.example.bankapplication.repository.UserRepository;
import com.example.bankapplication.user.LoginResponse;
import com.example.bankapplication.user.Role;
import com.example.bankapplication.user.User;
import jakarta.transaction.Transactional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
@Transactional
public class AuthenticationService {

    Logger logger =  LoggerFactory.getLogger(AuthenticationService.class);

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRespository roleRespository;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private TokenService tokenService;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public User registerUser(String username, String password)
    {
        String encodedPass = passwordEncoder.encode(password);

        Role userRole = roleRespository.findByAuthority("USER").get();
        Set<Role> authorities = new HashSet<>();

        authorities.add(userRole);

        return userRepository.save(new User(0L,username, encodedPass,authorities));
    }


    public String loginUser(String userName, String password)
    {
        try{ //1:30:00

            Authentication auth = authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(userName, password)
            );
            String token = tokenService.generateJwt(auth);
            //logger.info(String.valueOf(userRepository.findByUserName(userName).get()));
            //return new LoginResponse(userRepository.findByUserName(userName).get(), token);
           // return new LoginResponse(token);
            return token;
        }catch(AuthenticationException e){
            //return new LoginResponse("");
            return "";
        }
    }

}