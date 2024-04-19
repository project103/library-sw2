package com.library_management_system.library.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.library_management_system.library.entity.ShoppingCart;

public interface ShoppingCartRepository extends JpaRepository<ShoppingCart, Integer> {

}
