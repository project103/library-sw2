package com.library_management_system.library.repository;

import com.library_management_system.library.entity.user;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface userRepository extends JpaRepository<user,Integer> {
}
