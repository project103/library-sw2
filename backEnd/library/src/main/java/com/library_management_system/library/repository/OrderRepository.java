package com.library_management_system.library.repository;

import com.library_management_system.library.entity.Favorite;
import com.library_management_system.library.entity.Order;
import com.library_management_system.library.entity.ShoppingCart;
import com.library_management_system.library.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OrderRepository extends JpaRepository<Order, Integer> {
    Order findByuser(User user);

    void deleteByuser(User user);



    // You can add more custom query methods as needed
}
