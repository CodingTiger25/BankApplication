package com.example.bankapplication.repository;

import com.example.bankapplication.user.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RoleRespository extends JpaRepository<Role,Integer> {

    Optional<Role> findByAuthority(String authority);

}
