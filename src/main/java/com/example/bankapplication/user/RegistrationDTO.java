package com.example.bankapplication.user;

import lombok.Getter;
import lombok.Setter;

public class RegistrationDTO {

    @Getter @Setter
    private String userName;
    @Setter @ Getter
    private String password;

    public RegistrationDTO(){

        super();
    }

    public RegistrationDTO(String userName, String password){

        this.userName = userName;
        this.password = password;

    }
}
