package com.library_management_system.library.repository;

import com.library_management_system.library.entity.OrderItem;
import com.library_management_system.library.entity.ShoppingCart;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ShoppingCartRepository extends JpaRepository<ShoppingCart, Integer> {

    // You can add more custom query methods as needed
}
