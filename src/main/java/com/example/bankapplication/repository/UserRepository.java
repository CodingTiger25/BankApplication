package com.example.bankapplication.repository;

import com.example.bankapplication.user.User;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface UserRepository extends JpaRepository<User,Long>{

    User findById(Integer id);

    User findByUserNameAndPassword(String name, String password);

}
