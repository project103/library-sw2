package com.library_management_system.library.controller;

import com.library_management_system.library.entity.Book;
import com.library_management_system.library.entity.Category;
import com.library_management_system.library.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/categories")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @GetMapping
    public ResponseEntity<List<Category>> getAllCategories() {
        List<Category> categories = categoryService.getAllCategories();
        return ResponseEntity.ok(categories);
    }

    @PostMapping
    public ResponseEntity<Category> addCategory(@RequestBody Category category) {
        Category savedCategory = categoryService.addCategory(category);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedCategory);
    }

    @GetMapping("/getCategoryById/{id}")
    public ResponseEntity<Category> getCategoryById(@PathVariable int id) {
        Category category = categoryService.getCategoryById(id);
        return ResponseEntity.ok(category);
    }

    @GetMapping("/name/{name}")
    public ResponseEntity <Category> getCategoryByName(@PathVariable String name) {
        Category category = categoryService.getCategoryByName(name);
        return ResponseEntity.ok(category);
    }

    @PutMapping("/updateCategory/{id}")
    public ResponseEntity<Category> updateCategory(@PathVariable int id, @RequestBody Category category) {
        category.setId(id);
        Category updatedCategory = categoryService.updateCategory(category);
        return ResponseEntity.ok(updatedCategory);
    }

    @DeleteMapping("/deleteCategory/{id}")
    public ResponseEntity<String> deleteCategory(@PathVariable int id) {
        Category category = categoryService.getCategoryById(id);
        categoryService.deleteCategory(category);
        return ResponseEntity.ok("Category deleted successfully");
    }

    @PostMapping("/books/{categoryId}/{bookId}")
    public ResponseEntity<Book> addBookToCategory(@PathVariable String categoryName, @PathVariable int bookId, @PathVariable String bookName, @PathVariable String author, @PathVariable String description, @PathVariable double price, @PathVariable int copies, @PathVariable String format, @PathVariable int length, @PathVariable double rating, @PathVariable String edition, @PathVariable String language) {
        Book book = categoryService.AddBookToCategory(new Book(bookId, bookName, author, description, price, copies, format, length, rating, edition, language), new Category(categoryName));
        return ResponseEntity.status(HttpStatus.CREATED).body(book);
    }

    @DeleteMapping("/books/{categoryId}/{bookId}")
    public ResponseEntity<String> removeBookFromCategory(@PathVariable int categoryId, @PathVariable int bookId) {
        categoryService.RemoveBookFromCategory(new Book(bookId), new Category(categoryId));
        return ResponseEntity.ok("Book removed from category successfully");
    }
    
    
    
}

