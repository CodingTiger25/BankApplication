package com.example.bankapplication.controller;


import com.example.bankapplication.repository.UserRepository;
import com.example.bankapplication.service.AuthenticationService;
import com.example.bankapplication.service.TokenService;
import com.example.bankapplication.user.LoginResponse;
import com.example.bankapplication.user.RegistrationDTO;
import com.example.bankapplication.user.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.web.bind.annotation.*;

@RestController
public class LoginController {

    //private UserService userService;

    @Autowired
    private final UserRepository userRepository;

    @Autowired
    private final TokenService tokenService;

    @Autowired
    private final AuthenticationManager authenticationManager;

    @Autowired
    private AuthenticationService authenticationService;





    public LoginController(UserRepository userRepository, TokenService tokenService, AuthenticationManager authenticationManager)
    {
        this.userRepository = userRepository;
        this.tokenService = tokenService;
        this.authenticationManager = authenticationManager;
    }

    //@CrossOrigin(origins = "http://localhost:8080/")
   /*@GetMapping("/login")
   // public User getUser(@RequestParam Integer id)
    public String login(User user)
    {
        return "Welcome from " + user.getUsername();
    }*/

    @PostMapping("/login")
    public LoginResponse loginProcess(@RequestBody RegistrationDTO body)
    {
       /* System.out.println("BODY:  in login Response: " + user);
        System.out.println("UserName in login Response: " + user.getUserName());
        System.out.println("Password in login Response: " + user.getPassword());*/
        return authenticationService.loginUser(body.getUserName(), body.getPassword());

    }

  /*  @PostMapping("/token")
    public String token(@RequestBody LoginRequest loginRequest) throws AuthenticationException {

        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(log));

        return tokenService.generateJwt(authentication);

    }*/

}
