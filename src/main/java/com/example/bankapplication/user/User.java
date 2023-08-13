package com.example.bankapplication.user;

import lombok.*;
import jakarta.persistence.*;
import java.util.*;

@Entity
@Data
@Table(name = "users")

public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Getter @Setter
    String userName;

    @Getter @Setter
    String password;

    @Setter @Getter
    int checkingAmount;

    @Setter @Getter
    int savingAmount;
}
