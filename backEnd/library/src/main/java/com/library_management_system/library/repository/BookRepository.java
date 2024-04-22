package com.library_management_system.library.repository;

import com.library_management_system.library.entity.Book;
import com.library_management_system.library.entity.CartItem;
import com.library_management_system.library.entity.Category;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.*;

public interface BookRepository extends JpaRepository<Book, Integer> {
    List<Book> findByCategory(Category category);
    Book getBookById(int id);
    Book findByName(String name);
    
    // You can add more custom query methods as needed
}
