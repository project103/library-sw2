package com.library_management_system.library.controller;

import com.library_management_system.library.entity.CartItem;
import com.library_management_system.library.service.CartItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/cart-items")
public class CartItemController {

    @Autowired
    private CartItemService cartItemService;

    @PostMapping("/add")
    public ResponseEntity<Void> addItemToCart(@RequestBody Map<String , String> request) {
        cartItemService.addItem(Integer.parseInt(request.get("UserId")), Integer.parseInt(request.get("BookId")));
        return new ResponseEntity<>(HttpStatus.CREATED);
    }


    @GetMapping("/{userId}")
    public ResponseEntity<List<CartItem>> getCartItemsByUserId(@PathVariable int userId) {
        List<CartItem> cartItems = cartItemService.getCartItemById(userId);
        return new ResponseEntity<>(cartItems, HttpStatus.OK);
    }
}
