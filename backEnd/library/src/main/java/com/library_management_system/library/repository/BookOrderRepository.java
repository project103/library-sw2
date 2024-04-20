package com.library_management_system.library.repository;

import com.library_management_system.library.entity.BookOrder;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.*;

public interface BookOrderRepository extends JpaRepository<BookOrder, Integer> {
    List<BookOrder> findByOrderUserId(String userId);
}