package com.library_management_system.library.controller;

import com.library_management_system.library.entity.Book;
import com.library_management_system.library.entity.Category;
import com.library_management_system.library.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class suggestionController {
    @Autowired
    private SuggestionService suggestionService;

    @GetMapping("/suggestions/categories")
    public List<Category> getSuggestedCategories(@RequestParam("userId") int userId) {
        return suggestionService.getSuggestedCategories(userId);
    }

    @GetMapping("/suggestions/books")
    public List<Book> getSuggestedBooks(@RequestParam("categories") List<Category> categories) {
        return suggestionService.getSuggestedBooks(categories);
    }
}
