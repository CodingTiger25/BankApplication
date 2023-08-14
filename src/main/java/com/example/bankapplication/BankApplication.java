package com.example.bankapplication;

import com.example.bankapplication.repository.UserRepository;
import com.example.bankapplication.user.User;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import java.awt.*;
import java.io.File;


@SpringBootApplication
@EnableJpaRepositories(basePackageClasses = {UserRepository.class})
@EntityScan(basePackageClasses = {User.class})
@Configuration
public class BankApplication {

    public static void main(String[] args) {


        SpringApplication.run(BankApplication.class, args);
    }


    /*String url="home-page.html";
    File file = new File(url);
    Desktop.getDesktop().browse(file.toURI());*/


}
