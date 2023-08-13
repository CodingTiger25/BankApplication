package com.example.bankapplication;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.awt.*;
import java.io.File;

@SpringBootApplication
public class BankApplication {

    public static void main(String[] args) {
        SpringApplication.run(BankApplication.class, args);
    }


    /*String url="home-page.html";
    File file = new File(url);
    Desktop.getDesktop().browse(file.toURI());*/


}
