package com.library_management_system.library.repository;
import com.library_management_system.library.entity.User;
import com.library_management_system.library.entity.Visa;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Set;

public interface VisaRepository extends JpaRepository<Visa,Integer> {
    List<Visa> findAllByuserID(User userId);
}
