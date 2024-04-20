package com.library_management_system.library.repository;

import com.library_management_system.library.entity.ShoppingCart;
import com.library_management_system.library.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

public interface ShoppingCartRepository extends JpaRepository<ShoppingCart, Integer> {

    // Method to add a new shopping cart for a user by their ID


    // Method to update the order completion status by shopping cart ID
    @Transactional
    @Modifying
    @Query("UPDATE ShoppingCart s SET s.orderCompleted = :orderCompleted WHERE s.id = :cartId")
    void updateOrderCompletedStatus(int cartId, boolean orderCompleted);

    ShoppingCart findByuser(User user);

    void deleteByuser(User user);

    // You can add more custom query methods as needed
}
