package com.library_management_system.library.repository;

import com.library_management_system.library.entity.Order;
import com.library_management_system.library.entity.OrderItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderItemRepository extends JpaRepository<OrderItem, Integer> {

    // You can add more custom query methods as needed
}
