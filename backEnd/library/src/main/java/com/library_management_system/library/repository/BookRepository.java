package com.library_management_system.library.repository;

import com.library_management_system.library.entity.Book;
import com.library_management_system.library.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.*;

public interface BookRepository extends JpaRepository<Book, String> {
    List<Book> findByCategory(Category category);
}
