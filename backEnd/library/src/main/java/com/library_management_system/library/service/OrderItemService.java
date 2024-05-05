package com.library_management_system.library.service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import com.library_management_system.library.entity.*;
import com.library_management_system.library.repository.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderItemService {
    @Autowired
    private OrderItemRepository orderItemRepository;
    @Autowired
    private OrderRepository orderRepository;
    @Autowired
    private userRepository UserRepository;
    @Autowired
    private CartItemsRepository cartItemsRepository;
    @Autowired
    private ShoppingCartRepository shoppingCartRepository;

    public void addItem(int userId ,Order order) {
        User user = UserRepository.getUserById(userId);
        ShoppingCart shoppingCart = shoppingCartRepository.findByuser(user);
        List<CartItem> cartItems = cartItemsRepository.findAllByCart(shoppingCart);
        List<OrderItem> orderItems = new ArrayList<>();


        for (CartItem cartItem : cartItems) {
            OrderItem orderItem = new OrderItem();
            orderItem.setProduct(cartItem.getProduct());
            orderItem.setQuantity(cartItem.getQuantity());
            orderItem.setOrder(order);
            orderItem.setPrice(cartItem.getProduct().getPrice());
            if (LocalDateTime.now().isAfter(order.getReturnDeadline())) {
                orderItem.setFine(10);
            } else {
                orderItem.setFine(0);
            }
            orderItems.add(orderItem);
        }

        orderItemRepository.saveAll(orderItems);

        // delete cart items after converting them to order items
        cartItemsRepository.deleteAll(cartItems);
    }

    public List<OrderItem> getOrderItemsByUserId(int userId,int orderID) {
        User user = UserRepository.getUserById(userId);
        Order order = orderRepository.findByuserAndStatus(user , "");
        return orderItemRepository.findAllByOrder(order);
    }
}