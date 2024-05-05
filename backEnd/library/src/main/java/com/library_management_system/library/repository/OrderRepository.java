package com.library_management_system.library.repository;

import com.library_management_system.library.entity.Favorite;
import com.library_management_system.library.entity.Order;
import com.library_management_system.library.entity.ShoppingCart;
import com.library_management_system.library.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface OrderRepository extends JpaRepository<Order, Integer> {
    Order findByuser(User user);

    void deleteByuser(User user);

    @Query("SELECT o FROM Order o WHERE o.user = :user AND o.id = :id")
    Order findByUserAndId(@Param("user") User user, @Param("id") int id);

    Order findByuserAndStatus(User User, String s);


    // You can add more custom query methods as needed
}
