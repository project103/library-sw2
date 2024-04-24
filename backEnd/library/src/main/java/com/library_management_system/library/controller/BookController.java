package com.library_management_system.library.controller;

import com.library_management_system.library.entity.Book;
//import com.library_management_system.library.entity.Category;
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

    @GetMapping("/all")
    public List<Book> getAllBooks() {
        List<Book> books = bookService.getAllBooks();
        return books;
    }//check

    @GetMapping("/{id}")
    public Book getBookById(@PathVariable int id) {
        Book book = bookService.getBookById(id);
        return book;
    }//check but needs exception!


    @GetMapping("/{format}")
    public List<Book> getBookByFormat(@PathVariable String format) {
        List<Book> books = bookService.getBookByFormat(format);
        return books;
    }

    // @PostMapping("/add")
    // public Book addBook(@RequestBody Book book) {
        
    //     return bookService.addBook(book);
    // }

    @PutMapping("/update")
    public Book updateBook(@RequestBody Book book) {
        Book updatedBook = bookService.updateBook(book);
        return updatedBook;
    }//check

    @GetMapping("/category/{categoryName}")
    public List<Book> getBooksByCategory(@PathVariable String categoryName) {
        List<Book> books = bookService.getBookByCategory(categoryName);
        return books;
    }//check but needs exception

    @DeleteMapping("/delete/{id}")
    public String deleteBook(@PathVariable int id) {
        bookService.deleteBook(bookService.getBookById(id));
        return "Book deleted successfully";
    }//check but needs exception

    @PostMapping("/addBook/{categoryName}")
    public Book addBookToCategory(@PathVariable String categoryName,@RequestBody String bookName, @RequestBody String author, @RequestBody String description, @RequestBody double price, @RequestBody int copies, @RequestBody String format, @RequestBody int length, @RequestBody double rating, @RequestBody String edition, @RequestBody String language) {
        Book book = bookService.AddBookToCategory(new Book(bookName, author, description, price, copies, format, length, rating, edition, language), categoryName);
        return book;
    }

    @GetMapping("/name/{name}")
    public Book findBookByName(@PathVariable String name) {
        Book book = bookService.findBookByName(name);
        return book;
    }

    @DeleteMapping("/deleteBooks/{categoryName}/{bookName}")
    public String removeBookFromCategory(@PathVariable String categoryName, @PathVariable String bookName) {
        bookService.RemoveBookFromCategory(bookName, categoryName);
        return ("Book removed from category successfully");
    }

    @GetMapping("/categoryContent/{categoryName}")
        public List<Book> viewCategoryContent(@PathVariable String categoryName) {
        List<Book> books = bookService.getCategoryContent(categoryName);
        return books;
    }
}

