package com.library_management_system.library.repository;

import com.library_management_system.library.entity.Order;
import com.library_management_system.library.entity.OrderItem;
import com.library_management_system.library.entity.ShoppingCart;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OrderItemRepository extends JpaRepository<OrderItem, Integer> {
    List<OrderItem> findAllByOrder(Order order);

    // You can add more custom query methods as needed
}
