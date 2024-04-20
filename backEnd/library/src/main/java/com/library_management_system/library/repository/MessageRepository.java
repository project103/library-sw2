package com.library_management_system.library.repository;

import com.library_management_system.library.entity.Message;
import com.library_management_system.library.entity.Review;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MessageRepository extends JpaRepository<Message, Integer> {

    // You can add more custom query methods as needed
}
