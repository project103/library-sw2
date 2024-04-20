package com.library_management_system.library.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.library_management_system.library.entity.CartItem;

public interface CartItemsRepository extends JpaRepository<CartItem, Integer> {

}
