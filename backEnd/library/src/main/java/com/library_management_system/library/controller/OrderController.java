package com.library_management_system.library.controller;

import com.library_management_system.library.entity.Book;
import com.library_management_system.library.entity.Order;
import com.library_management_system.library.entity.OrderItem;
import com.library_management_system.library.repository.SuggestionRepository;
import com.library_management_system.library.service.OrderItemService;
import com.library_management_system.library.service.OrderService;
import com.library_management_system.library.service.SuggestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/orders")
public class OrderController {

    @Autowired
    private OrderService orderService;
    @Autowired
    private SuggestionService suggestionService;
    @Autowired
    private OrderItemService orderItemService;

    @PostMapping("/add/{id}")
    public ResponseEntity<Void> addOrder(@PathVariable  int id) {
        orderService.addOrder(id);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping("/{userId}/{orderId}")
    public ResponseEntity<Order> getOrder(@PathVariable int userId, @PathVariable int orderId) {
        Order order = orderService.getOrder(userId, orderId);
        return new ResponseEntity<>(order, HttpStatus.OK);
    }

    @DeleteMapping("/{orderId}")
    public ResponseEntity<Void> removeOrder(@PathVariable int orderId) {
        orderService.removeOrder(orderId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PostMapping("/CheckOut/{userId}")
    public ResponseEntity<Void> checkoutOrder(@PathVariable int userId) {
        int orderId = orderService.checkOut(userId);
        List<OrderItem> orderItems = orderItemService.getOrderItemsByUserId(userId,orderId);

        suggestionService.addSuggestion(userId,orderItems);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/check-completed/{orderId}")
    public ResponseEntity<Boolean> checkOrderCompleted(@PathVariable int orderId) {

        boolean completed = orderService.checkOrderCompleted(orderId);
        return new ResponseEntity<>(completed, HttpStatus.OK);
    }
}
