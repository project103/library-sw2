package com.library_management_system.library.repository;

import com.library_management_system.library.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface userRepository extends JpaRepository<User,Integer> {
}
