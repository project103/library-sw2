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


    /*public Book updateBook(int bookId, Book updatedBook) {
        Book existingBook = bookRepository.findById(bookId).orElse(null);
        
        existingBook.setName(updatedBook.getName());
        existingBook.setAuthor(updatedBook.getAuthor());
        existingBook.setDescription(updatedBook.getDescription());
        existingBook.setPrice(updatedBook.getPrice());
        existingBook.setEdition(updatedBook.getEdition());
        existingBook.setLanguage(updatedBook.getLanguage());
        return bookRepository.save(existingBook);
    }*/
    public Book updateBook(int bookId, Book updatedBook) {
        Book existingBook = bookRepository.findById(bookId).orElse(null);

        if (updatedBook.getName() != null) {
            existingBook.setName(updatedBook.getName());
        }
        if (updatedBook.getAuthor() != null) {
            existingBook.setAuthor(updatedBook.getAuthor());
        }
        if (updatedBook.getDescription() != null) {
            existingBook.setDescription(updatedBook.getDescription());
        }
        if (updatedBook.getPrice() != null) {
            existingBook.setPrice(updatedBook.getPrice());
        }
        if (updatedBook.getEdition() != null) {
            existingBook.setEdition(updatedBook.getEdition());
        }
        if (updatedBook.getLanguage() != null) {
            existingBook.setLanguage(updatedBook.getLanguage());
        }
        if (updatedBook.getFormat() != null) {
            existingBook.setFormat(updatedBook.getFormat());
        }
        if (updatedBook.getCategory().getName() != null) {
            Category existingCategory = categoryRepository.findByName(updatedBook.getCategory().getName());
                existingCategory.setName(updatedBook.getCategory().getName());
                existingBook.setCategory(existingCategory);
        }
        if (updatedBook.getCopies() != null) {
            existingBook.setCopies(updatedBook.getCopies());
        }
        if (updatedBook.getRating() != null) {
            existingBook.setRating(updatedBook.getRating());
        }
        if (updatedBook.getLength() != null) {
            existingBook.setLength(updatedBook.getLength());
        }

        return bookRepository.save(existingBook);
    }



    public List<Book> getBookByLanguage(String language){
        return bookRepository.findByLanguage(language);
    }

    public Book AddBookToCategory(Book book, String categoryName){
        if(book.getFormat().equals("Audio")) {
            book.setCopies(1);
        }
        
        
        book.setCategory(category);
        return bookRepository.save(book);
    }

    public List<Book> getCategoryContent(String categoryName){
        return bookRepository.findByCategory(category);
    }

    public void RemoveBookFromCategory(String bookName, String categoryName){
        Book book = findBookByName(bookName);
        getCategoryContent(categoryName).remove(book);
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
