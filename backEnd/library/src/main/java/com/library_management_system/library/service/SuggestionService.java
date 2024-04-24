package com.library_management_system.library.service;
import com.library_management_system.library.entity.*;
import com.library_management_system.library.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;
@Service
public class SuggestionService {
    @Autowired
    private userRepository Repository;
    @Autowired
    private BookRepository bookRepository;
    @Autowired
    private SuggestionRepository suggestionRepository;


    // Updated method to use bookRepository instance
    public List<Category> getSuggestedCategories(int userId) {
        User user = Repository.getUserById(userId);
        List<Suggestion> suggestions = suggestionRepository.findByUser(user);
        List<Category> categories = new ArrayList<>();
        for (Suggestion suggestion : suggestions) {
            categories.add(suggestion.getSuggestedBook().getCategory());
        }
        return categories;
    }

    public List<Book> getSuggestedBooks(List<Category> categories) {
        List<Book> bookList = new ArrayList<>();
        for (Category category : categories) {
            List<Book> booksInCategory = bookRepository.findByCategory(category);
            bookList.addAll(booksInCategory);
        }
        return bookList;
    }

    public void addSuggestion(int userId, List<OrderItem> orderItems) {
        User user = Repository.getUserById(userId);
        for (OrderItem orderItem : orderItems) {
            Book book = orderItem.getProduct(); // Assuming getProduct() returns the Book associated with the OrderItem
            Suggestion suggestion = new Suggestion();
            suggestion.setSuggestedBook(book);
            suggestion.setUser(user);
            suggestionRepository.save(suggestion);
        }
    }
}
