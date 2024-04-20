package com.library_management_system.library.repository;

import com.library_management_system.library.entity.CartItem;
import com.library_management_system.library.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CartitemRepository extends JpaRepository<CartItem, Integer> {

    // You can add more custom query methods as needed
}
