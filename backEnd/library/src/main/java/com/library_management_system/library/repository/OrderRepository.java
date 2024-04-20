package com.library_management_system.library.repository;

import com.library_management_system.library.entity.Favorite;
import com.library_management_system.library.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OrderRepository extends JpaRepository<Order, Integer> {

    // You can add more custom query methods as needed
}
