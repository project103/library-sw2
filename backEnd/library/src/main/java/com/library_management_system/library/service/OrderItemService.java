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


    public ShoppingCart getShoppingCartByUserId(int userId) {
        User user = UserRepository.getUserById(userId);
        return shoppingCartRepository.findByuser(user);
    }


    public void addItem(int userId) {
        ShoppingCart cart = getShoppingCartByUserId(userId);
        if (cart == null) {
            
            return;
        }

        List<CartItem> cartItems = cartItemsRepository.findAllByCart(cart);
        Order order = orderRepository.findByuser(getUserByUserId(userId));
        if (order == null) {

            return;
        }

        List<OrderItem> orderItems = new ArrayList<>();

        for (CartItem cartItem : cartItems) {
            OrderItem orderItem = createOrderItemFromCartItem(cartItem, order);
            orderItems.add(orderItem);
        }

        orderItemRepository.saveAll(orderItems);
        cartItemsRepository.deleteAll(cartItems);
    }
    private User getUserByUserId(int userId) {
        return UserRepository.getUserById(userId);
    }

    private OrderItem createOrderItemFromCartItem(CartItem cartItem, Order order) {
        OrderItem orderItem = new OrderItem();
        orderItem.setProduct(cartItem.getProduct());
        orderItem.setQuantity(cartItem.getQuantity());
        orderItem.setOrder(order);
        orderItem.setPrice(cartItem.getProduct().getPrice());
        orderItem.setFine(calculateFine(order));
        return orderItem;
    }

    private int calculateFine(Order order) {
        if (LocalDateTime.now().isAfter(order.getReturnDeadline())) {
            return 10;
        } else {
            return 0;
        }
    }


    public List<OrderItem> getOrderItemsByUserId(int userId , int orderId) {
        User user = UserRepository.getUserById(userId);
        Order order = orderRepository.findByUserAndId(user, orderId);
        return orderItemRepository.findAllByOrder(order);
    }
}

