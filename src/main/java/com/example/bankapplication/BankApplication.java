package com.example.bankapplication;

import com.example.bankapplication.repository.RoleRespository;
import com.example.bankapplication.repository.UserRepository;
import com.example.bankapplication.user.Role;
import com.example.bankapplication.user.User;
import com.example.bankapplication.utils.RSAKeyProperties;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.awt.*;
import java.io.File;
import java.util.HashSet;
import java.util.Set;


@SpringBootApplication
@EnableConfigurationProperties
@EnableJpaRepositories(basePackageClasses = {UserRepository.class})
@EntityScan(basePackageClasses = {User.class, Role.class})
@Configuration
public class BankApplication {

    public static void main(String[] args) {


        SpringApplication.run(BankApplication.class, args);
    }

    @Bean //53:00
    CommandLineRunner run(RoleRespository roleRespository, UserRepository userRepository,
                          PasswordEncoder passwordEncoder){

        return args -> {
            if(roleRespository.findByAuthority("ADMIN").isPresent()) return;
            Role adminRole = roleRespository.save(new Role("ADMIN"));
            roleRespository.save(new Role("USER"));

            Set<Role> roles = new HashSet<>();
            roles.add(adminRole);

            User admin = new User(1L,"admin", passwordEncoder.encode("pasword"), roles);

            userRepository.save(admin);
        };
    }




    /*String url="home-page.html";
    File file = new File(url);
    Desktop.getDesktop().browse(file.toURI());*/


}
