package com.library_management_system.library.repository;

import com.library_management_system.library.entity.Book;
import com.library_management_system.library.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BookRepository extends JpaRepository<Book, Integer> {
    Book getBookById(int id);

    Book getBookByname(String bookId);
    List<Book> findBookByCategory(Category category);

    // You can add more custom query methods as needed
}
