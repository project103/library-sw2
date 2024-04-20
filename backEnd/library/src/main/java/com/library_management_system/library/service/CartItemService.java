package com.library_management_system.library.service;

import com.library_management_system.library.entity.Book;
import com.library_management_system.library.entity.CartItem;
import com.library_management_system.library.entity.ShoppingCart;
import com.library_management_system.library.entity.User;
import com.library_management_system.library.repository.BookRepository;
import com.library_management_system.library.repository.CartItemsRepository;
import com.library_management_system.library.repository.ShoppingCartRepository;
import com.library_management_system.library.repository.userRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CartItemService {
    @Autowired
    private CartItemsRepository repository;
    @Autowired
    private ShoppingCartRepository shoppingCartRepository;
    @Autowired
    private userRepository UserRepository;
    @Autowired
    private BookRepository bookRepository;


    public void addItem(int userId, int bookId, int quantity) {
        User user = UserRepository.getUserById(userId);
        Book book = bookRepository.getBookById(bookId);
        ShoppingCart shoppingCart = shoppingCartRepository.findByuser(user);


        if (shoppingCart == null) {
            shoppingCart = new ShoppingCart();
            shoppingCart.setUser(user);
            shoppingCartRepository.save(shoppingCart);
        }
        shoppingCart.setOrderCompleted(false);
    CartItem cartItem = new CartItem();
        cartItem.setProduct(book);
        cartItem.setCart(shoppingCart);
        cartItem.setQuantity(quantity);
        repository.save(cartItem);
}
    public List<CartItem> getCartItemById(int userId) {
        User user = UserRepository.getUserById(userId);
        ShoppingCart shoppingCart = shoppingCartRepository.findByuser(user);
        return  repository.findAllByCart(shoppingCart);
    }

    }



