package com.library_management_system.library.service;

import com.library_management_system.library.entity.Order;
import com.library_management_system.library.entity.ShoppingCart;
import com.library_management_system.library.entity.User;
import com.library_management_system.library.repository.OrderRepository;
import com.library_management_system.library.repository.ShoppingCartRepository;
import com.library_management_system.library.repository.userRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

@Service
public class OrderService {
    @Autowired
    private OrderRepository repository;
    @Autowired
    private userRepository User;

    public void addOrder(int userId){
        Order order = new Order();
        User user = User.getUserById(userId);
        order.setUser(user);
        order.setOrderDate(LocalDateTime.now());
        LocalDateTime returnDeadline = order.getOrderDate().plus(1, ChronoUnit.WEEKS);
        order.setReturnDeadline(returnDeadline);
        repository.save(order);
    }
    public Order getOrder(int userId){
        User user = User.getUserById(userId);
        return repository.findByuser(user);
    }

    public void removeOrder(int userId){
        User user = User.getUserById(userId);
        repository.deleteByuser(user);
    }




}
