package com.library_management_system.library.repository;
import com.library_management_system.library.entity.Category;
import com.library_management_system.library.entity.Book;
import com.library_management_system.library.entity.Suggestion;
import com.library_management_system.library.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface BookRepository extends JpaRepository<Book, Integer> {
    Book getBookById(int id);

    List<Book> findByCategory(Category category);
    List<Book> findByFormat(String format);
    Book findByName(String name);
    List<Book> findByLanguage(String language);
}
