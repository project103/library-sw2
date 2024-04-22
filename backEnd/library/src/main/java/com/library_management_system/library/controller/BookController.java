package com.library_management_system.library.controller;

import com.library_management_system.library.entity.Book;
import com.library_management_system.library.entity.Category;
import com.library_management_system.library.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/books")
public class BookController {

    @Autowired
    private BookService bookService;

    @GetMapping
    public ResponseEntity<List<Book>> getAllBooks() {
        List<Book> books = bookService.getAllBooks();
        return ResponseEntity.ok(books);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Book> getBookById(@PathVariable int id) {
        Book book = bookService.getBookById(id);
        return ResponseEntity.ok(book);
    }

    @PostMapping
    public ResponseEntity<Book> addBook(@RequestBody Book book) {
        Book savedBook = bookService.addBook(book);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedBook);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Book> updateBook(@PathVariable int id, @RequestBody Book book) {
        book.setId(id);
        Book updatedBook = bookService.updateBook(book);
        return ResponseEntity.ok(updatedBook);
    }

    @GetMapping("/category/{categoryId}")
    public ResponseEntity<List<Book>> getBooksByCategory(@PathVariable int categoryId) {
        Category category = new Category(categoryId);
        List<Book> books = bookService.getBookByCategory(category);
        return ResponseEntity.ok(books);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteBook(@PathVariable int id) {
        bookService.deleteBook(bookService.getBookById(id));
        return ResponseEntity.ok("Book deleted successfully");
    }

    @GetMapping("/name/{name}")
    public ResponseEntity<Book> findBookByName(@PathVariable String name) {
        Book book = bookService.findBookByName(name);
        return ResponseEntity.ok(book);
    }
}

