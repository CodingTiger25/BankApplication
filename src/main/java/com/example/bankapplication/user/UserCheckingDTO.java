package com.example.bankapplication.user;

import lombok.Getter;
import lombok.Setter;

public class UserCheckingDTO {

    @Getter
    @Setter
    private String userName;
    @Setter @Getter
    private int checking_amount;

    public UserCheckingDTO(){

        super();
    }

    public UserCheckingDTO(String userName, int checking_amount){

        this.userName = userName;
        this.checking_amount = checking_amount;

    }
}
