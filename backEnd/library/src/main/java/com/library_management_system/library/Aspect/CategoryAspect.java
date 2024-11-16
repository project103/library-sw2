package com.library_management_system.library.Aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.beans.factory.annotation.Autowired;

import com.library_management_system.library.entity.Book;
import com.library_management_system.library.entity.Category;
import com.library_management_system.library.repository.CategoryRepository;

@Aspect
public class CategoryAspect {
    @Autowired
    private CategoryRepository categoryRepository;

    @Before("execution(* com.library_management_system.library.service.BookService.AddBookToCategory(..)) && args(book, categoryName) || execution(* com.library_management_system.library.service.BookService.getCategoryContent(..)) && args(categoryName)")
    public void findByName(String categoryName, Book book){
        Category category = categoryRepository.findByName(categoryName);    }
}
