package com.example.bankapplication.user;

import lombok.*;
import jakarta.persistence.*;
import java.util.*;

@Entity
@Data
@Table(name = "users")

public class User {

    @Id
    @Column(name="id", nullable = false, columnDefinition = "serial")
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Getter @Setter
    private Long id;

    @Getter @Setter
    String user_name;

    @Getter @Setter
    String password;

    @Setter @Getter
    int checking_amount;

    @Setter @Getter
    int saving_amount;
}
