package com.library_management_system.library.repository;

import com.library_management_system.library.entity.Book;
import com.library_management_system.library.entity.CartItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, Integer> {
    Book getBookById(int id);

    Book getBookByname(String bookId);

    // You can add more custom query methods as needed
}
