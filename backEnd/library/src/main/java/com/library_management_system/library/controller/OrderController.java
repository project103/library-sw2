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

    @PostMapping("/add")
    public ResponseEntity<Void> addOrder(@RequestParam("userId") int userId) {
        orderService.addOrder(userId);
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

    @PostMapping("/{orderId}/{userId}/checkout")
    public ResponseEntity<Void> checkoutOrder(@PathVariable int orderId, @PathVariable int userId) {
        orderService.checkOut(orderId);
        List<OrderItem> orderItems = orderItemService.getOrderItemsByUserId(orderId, userId);

        suggestionService.addSuggestion(userId,orderItems);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/{orderId}/check-completed")
    public ResponseEntity<Boolean> checkOrderCompleted(@PathVariable int orderId) {

        boolean completed = orderService.checkOrderCompleted(orderId);
        return new ResponseEntity<>(completed, HttpStatus.OK);
    }
}
