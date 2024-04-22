package com.library_management_system.library.repository;

import com.library_management_system.library.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface userRepository extends JpaRepository<User,Integer> {


   

    User getUserById(int userId) ;


    User findByname(String username);


    List<User> findByEmail(String email);
}
