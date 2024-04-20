package com.library_management_system.library.service;

import com.library_management_system.library.entity.ShoppingCart;
import com.library_management_system.library.entity.User;
import com.library_management_system.library.repository.ShoppingCartRepository;
import com.library_management_system.library.repository.userRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ShoppingCartService {
    @Autowired
    private ShoppingCartRepository repository;
    @Autowired
    private userRepository User;

    public void addCart(int userId){
        ShoppingCart shoppingCart = new ShoppingCart();
        User user = User.getUserById(userId);
        shoppingCart.setUser(user);
        shoppingCart.setOrderCompleted(false); // Assuming the order is not completed initially
        repository.save(shoppingCart);
    }

    public ShoppingCart getCart(int userId){
        User user = User.getUserById(userId);
        return repository.findByuser(user);
    }
    public void updateOrderComplete(int cartId, boolean orderCompleted){
        repository.updateOrderCompletedStatus(cartId, orderCompleted);
    }

    public void remove(int userId){
        User user = User.getUserById(userId);
        repository.deleteByuser(user);
    }

}
