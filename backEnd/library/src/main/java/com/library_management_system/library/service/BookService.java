package com.library_management_system.library.service;

import com.library_management_system.library.Exceptions.NotFoundException;
import com.library_management_system.library.entity.Book;
import com.library_management_system.library.entity.Category;
import com.library_management_system.library.repository.BookRepository;
import com.library_management_system.library.repository.CategoryRepository;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service

public class BookService {
    @Autowired
    private BookRepository bookRepository;
    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private Category category;


    public List<Book> getAllBooks() {
        return bookRepository.findAll();

    }

    public Book getBookById(int id) {
            return bookRepository.getBookById(id);
        }

    public List<Book> getBookByFormat(String format) {
        return bookRepository.findByFormat(format);
    }


    public Book updateBook(int bookId, Book updatedBook) {
        Book existingBook = bookRepository.findById(bookId).orElse(null);
        
        existingBook.setName(updatedBook.getName());
        existingBook.setAuthor(updatedBook.getAuthor());
        existingBook.setDescription(updatedBook.getDescription());
        existingBook.setPrice(updatedBook.getPrice());
        existingBook.setEdition(updatedBook.getEdition());
        existingBook.setLanguage(updatedBook.getLanguage());
        return bookRepository.save(existingBook);
    }

    public List<Book> getBookByCategory(String categoryName){
        
        try {
            Category category = categoryRepository.findByName(categoryName);
            return bookRepository.findByCategory(category);
          } catch (Exception e) {
            System.out.println("There's no Books in category: " + categoryName);
          }
        return null;
    }

    public List<Book> getBookByLanguage(String language){
        return bookRepository.findByLanguage(language);
    }

    public Book AddBookToCategory(Book book, String categoryName){
        
        if(book.getFormat().equals("Audio")) {
            book.setCopies(1);
        }
        Category category = categoryRepository.findByName(categoryName);
        
        book.setCategory(category);
        return bookRepository.save(book);
    }

    public List<Book> getCategoryContent(String categoryName){
        Category category = categoryRepository.findByName(categoryName);
        return bookRepository.findByCategory(category);
    }

    public void RemoveBookFromCategory(String bookName, String categoryName){
        Book book = findBookByName(bookName);
        getBookByCategory(categoryName).remove(book);
    }


    public void deleteBook(Book book) {
        bookRepository.deleteById(book.getId());
    }

    public Book findBookByName(String name) {
        Book book = bookRepository.findByName(name);
        if (book==null){
            throw new NotFoundException("No books found with the name: " + name);
        }
        return book;
    }






    
}
