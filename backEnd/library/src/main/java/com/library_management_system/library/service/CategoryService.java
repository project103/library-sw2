package com.library_management_system.library.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.library_management_system.library.Exceptions.NotFoundException;
import com.library_management_system.library.entity.Book;
import com.library_management_system.library.entity.Category;
import com.library_management_system.library.repository.BookRepository;
import com.library_management_system.library.repository.CategoryRepository;
import java.util.*;

@Service
public class CategoryService {
    @Autowired
    private CategoryRepository categoryRepository;
    @Autowired
    private Category category;
    

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
}
