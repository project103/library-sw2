package com.library_management_system.library.service;

import com.library_management_system.library.Exceptions.NotFoundException;
import com.library_management_system.library.entity.Book;
import com.library_management_system.library.entity.Category;
import com.library_management_system.library.repository.BookRepository;
import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service

public class BookService {
    @Autowired
    private BookRepository bookRepository;


    public List<Book> getAllBooks() {
        return bookRepository.findAll();

    }

    public Book getBookById(int id) {
            return bookRepository.findById(id)
                    .orElseThrow(() -> new NotFoundException("Book not found with id: " + id));
        }

    public Book addBook(Book book) {
        int CurrentCopies = book.getCopies()+1;
        if (book.getFormat()=="Audio"){
            CurrentCopies=1;
        }
        return bookRepository.save(book);
    }

    public Book updateBook(Book book) {
        
        Book existingBook = bookRepository.findById(book.getId()).orElse(null);
        existingBook.setId(book.getId());
        existingBook.setName(book.getName());
        existingBook.setAuthor(book.getAuthor());
        existingBook.setDescription(book.getDescription());
        existingBook.setCategory(book.getCategory());
        existingBook.setPrice(book.getPrice());
        return bookRepository.save(existingBook);
        
    }

    public List<Book> getBookByCategory(Category category){
        List<Book> books= bookRepository.findByCategory(category);
        if (books.isEmpty()){
            throw new NotFoundException("No books found with the category: " + category);
        }
        return books;
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
