package com.library_management_system.library.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.library_management_system.library.Exceptions.NotFoundException;
import com.library_management_system.library.entity.Book;
import com.library_management_system.library.entity.Category;
import com.library_management_system.library.repository.CategoryRepository;
import java.util.*;

@Service
public class CategoryService {
    @Autowired
    private CategoryRepository categoryRepository;
    @Autowired
    private Category category;
    @Autowired
    private BookService bookService;

    public List<Category> getAllCategories() {
        return categoryRepository.findAll();
    }

    public Category addCategory(Category category) {
        if (categoryRepository.findByName(category.getName())!=null) {
            throw new NotFoundException("Category already exists with name: " + category.getName());
        }
        return categoryRepository.save(category);
    }

    public Category getCategoryById(int id) {
        return categoryRepository.findById(id)
               .orElseThrow(() -> new NotFoundException("Category not found with id: " + category.getId()));
    }

    public Category getCategoryByName(String name) {
        category = categoryRepository.findByName(name);
        if (categoryRepository.findByName(name)==null) {
            throw new NotFoundException("Category not found with name: " + category.getName());
        }
        return category;
    }


    public void deleteCategory(Category category){
        if (category==null){
            throw new NotFoundException("Category "+ category + " does not exist!");
        }
        categoryRepository.delete(category);
    }

    public Category updateCategory(Category category){
        
        Category existingCategory = categoryRepository.findById(category.getId()).orElse(null);
        existingCategory.setId(category.getId());
        existingCategory.setName(category.getName());

        return categoryRepository.save(existingCategory);
    }

    public Book AddBookToCategory(Book book, Category category){
        book = bookService.getBookById(book.getId());
        
        category = getCategoryById(category.getId());

        book.setCategory(category);
        bookService.getBookByCategory(category).add(book);

        return bookService.addBook(book);
    }

    public void RemoveBookFromCategory(Book book, Category category){
        book = bookService.getBookById(book.getId());
        bookService.getBookByCategory(category).remove(book);
    }
}
