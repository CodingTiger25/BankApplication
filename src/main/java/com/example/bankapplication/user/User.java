package com.example.bankapplication.user;

import lombok.*;
import jakarta.persistence.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.*;

@Entity
@Data
@Table(name = "users")

public class User implements UserDetails {

    @Id
    @Column(name="id", nullable = false, columnDefinition = "serial")
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Getter @Setter
    private Long id;

    //@Getter @Setter
    @Column(name="userName", unique = true)
    String userName;

    @Getter @Setter
     @Column(name = "password")
    String password;

    @Setter @Getter
    int checking_amount;

    @Setter @Getter
    int saving_amount;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
        name="user_role_junction",
        joinColumns = {@JoinColumn(name="id")},
        inverseJoinColumns = {@JoinColumn(name="role_id")
    })

    @Setter
    private Set<Role> authorities;

    public User(){
        super();
        authorities = new HashSet<>();
    }

    public User(Long id, String userName, String password, Set<Role> authorities){
        super();
        this.id = id;
        this.userName = userName;
        this.password = password;
        this.authorities = authorities;
    }

    public User(Long id, String userName, String password, Integer checking_amount, Integer saving_amount, Set<Role> authorities){
        super();
        this.id = id;
        this.userName = userName;
        this.password = password;
        this.checking_amount = checking_amount;
        this.saving_amount = saving_amount;
        this.authorities = authorities;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return this.authorities;
    }

    @Override
    public String getUsername() {
        return this.userName;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
