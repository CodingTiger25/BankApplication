package com.example.bankapplication.repository;

import com.example.bankapplication.user.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User,Long>{

   // User findById(Integer id);

    //@Query("SELECT * FROM users where user_name = userName")
    Optional<User> findByUserName(String userName);

    //Optional<User> findByUser_name(String userName);


}
