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
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


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

    @PutMapping("/update/{bookId}")
    public Book updateBook(@PathVariable int bookId ,@RequestBody Book book) {
        return bookService.updateBook(bookId, book);
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
        book.setAuthor(NewBook.get("author"));
        book.setDescription(NewBook.get("description"));
        book.setPrice(Double.parseDouble(NewBook.get("price")));
        book.setCopies(Integer.parseInt(NewBook.get("copies")));
        book.setFormat(NewBook.get("format"));
        book.setLength(Integer.parseInt(NewBook.get("length")));
        book.setRating(Double.parseDouble(NewBook.get("rating")));
        book.setEdition(NewBook.get("edition"));
        book.setLanguage(NewBook.get("language"));

        return bookService.AddBookToCategory(book, categoryName);
    }

    @GetMapping("/name/{name}")
    public Book findBookByName(@PathVariable String name) {
        return bookService.findBookByName(name);
    }

    @GetMapping("/language/{language}")
    public List<Book> getBookByLanguage(@PathVariable String language) {
        return bookService.getBookByLanguage(language);
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

