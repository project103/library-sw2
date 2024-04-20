package com.library_management_system.library.repository;

import com.library_management_system.library.entity.ShoppingCart;
import com.library_management_system.library.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import com.library_management_system.library.entity.CartItem;

import java.util.List;

public interface CartItemsRepository extends JpaRepository<CartItem, Integer> {

    List<CartItem> findAllByCart(ShoppingCart shoppingCart);
}
