package com.example.bankapplication.user;

import lombok.Getter;
import lombok.Setter;

public class LoginResponse {

    @Getter @Setter
    private User user;

    @Getter @Setter
    private String jwt;

    public LoginResponse(){
        super();
    }

    public LoginResponse(User user, String jwt){

        this.user = user;
        this.jwt = jwt;
    }



}
