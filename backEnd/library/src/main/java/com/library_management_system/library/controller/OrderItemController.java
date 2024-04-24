package com.library_management_system.library.controller;

import com.library_management_system.library.entity.OrderItem;
import com.library_management_system.library.service.OrderItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/order-items")
public class OrderItemController {

    @Autowired
    private OrderItemService orderItemService;

    @PostMapping("/add/{userId}")
    public ResponseEntity<Void> addOrderItems(@PathVariable int userId) {
        orderItemService.addItem(userId);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping("/{userId}/{orderId}")
    public ResponseEntity<List<OrderItem>> getOrderItemsByUserId(@PathVariable int userId, @PathVariable int orderId) {
        List<OrderItem> orderItems = orderItemService.getOrderItemsByUserId(userId, orderId);
        return new ResponseEntity<>(orderItems, HttpStatus.OK);
    }
}
