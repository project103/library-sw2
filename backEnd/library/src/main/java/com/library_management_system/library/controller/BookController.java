package com.library_management_system.library.controller;

import com.library_management_system.library.entity.Book;
//import com.library_management_system.library.entity.Category;
import com.library_management_system.library.entity.Category;
import com.library_management_system.library.repository.CategoryRepository;
import com.library_management_system.library.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/books")
public class BookController {

    @Autowired
    private BookService bookService;
    @Autowired
    private CategoryRepository categoryRepository;

    @GetMapping("/all")
    public List<Book> getAllBooks() {
        return bookService.getAllBooks();
    }//check

    @GetMapping("/GetById/{id}")
    public Book getBookById(@PathVariable int id) {
        return bookService.getBookById(id);
    }//check but needs exception!


    @GetMapping("/GetByFormat /{format}")
    public List<Book> getBookByFormat(@PathVariable String format) {
        return bookService.getBookByFormat(format);
    }

    // @PostMapping("/add")
    // public Book addBook(@RequestBody Book book) {
        
    //     return bookService.addBook(book);
    // }

    @PutMapping("/update")
    public Book updateBook(@RequestBody Book book) {
        return bookService.updateBook(book);
    }//check

    @GetMapping("/category/{categoryName}")
    public List<Book> getBooksByCategory(@PathVariable String categoryName) {
        return bookService.getBookByCategory(categoryName);
    }//check but needs exception

    @DeleteMapping("/delete/{id}")
    public String deleteBook(@PathVariable int id) {
        bookService.deleteBook(bookService.getBookById(id));
        return "Book deleted successfully";
    }//check but needs exception

    @PostMapping("/addBook/{categoryName}")
    public Book addBookToCategory(@PathVariable String categoryName,@RequestBody Map<String , String> NewBook) {
        Book book = new Book();
        Category category = categoryRepository.findByName(NewBook.get("category"));
        book.setCategory(category);
        book.setName(NewBook.get("BookName"));
        // set all attributes yaa marwaa





        return bookService.AddBookToCategory(book, categoryName);
    }

    @GetMapping("/name/{name}")
    public Book findBookByName(@PathVariable String name) {
        return bookService.findBookByName(name);
    }

    @DeleteMapping("/deleteBooks/{categoryName}/{bookName}")
    public String removeBookFromCategory(@PathVariable String categoryName, @PathVariable String bookName) {
        bookService.RemoveBookFromCategory(bookName, categoryName);
        return ("Book removed from category successfully");
    }

    @GetMapping("/categoryContent/{categoryName}")
        public List<Book> viewCategoryContent(@PathVariable String categoryName) {
        return bookService.getCategoryContent(categoryName);
    }
}

