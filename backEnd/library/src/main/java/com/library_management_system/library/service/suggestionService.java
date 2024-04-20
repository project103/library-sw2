package com.library_management_system.library.service;
import com.library_management_system.library.entity.Book;
import com.library_management_system.library.entity.Category;
import com.library_management_system.library.entity.BookOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.library_management_system.library.repository.BookRepository;
import com.library_management_system.library.repository.BookOrderRepository;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.*;
@Service
public class suggestionService {
    @Autowired
    private BookOrderRepository bookOrderRepository;

    @Autowired
    private BookRepository bookRepository;

    public List<String> suggestBooks(String userId) {
        List<BookOrder> bookOrders = bookOrderRepository.findByOrderUserId(userId);
        Set<Category> categories = new HashSet<>();
        for (BookOrder bookOrder : bookOrders) {
            categories.add(bookOrder.getBook().getCategory());
        }
        List<String> suggestions = new ArrayList<>();
        for (Category category : categories) {
            List<Book> booksInCategory = bookRepository.findByCategory(category);
            for (Book book : booksInCategory) {
                if (!isBookOrderedByUser(book.getId(), bookOrders)) {
                    suggestions.add(book.getName());
                }
            }
        }
        return suggestions;
    }

    private boolean isBookOrderedByUser(int bookId, List<BookOrder> bookOrders) {
        for (BookOrder bookOrder : bookOrders) {
            if (bookOrder.getBook().getId() == bookId) {
                return true;
            }
        }
        return false;
    }


}

