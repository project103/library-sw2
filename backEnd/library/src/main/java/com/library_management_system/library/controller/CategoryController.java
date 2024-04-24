package com.library_management_system.library.controller;

//import com.library_management_system.library.entity.Book;
import com.library_management_system.library.entity.Category;
//import com.library_management_system.library.service.BookService;
import com.library_management_system.library.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/categories")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;
    //@Autowired
    //private BookService bookService;

    @GetMapping("/all")
    public List<Category> getAllCategories() {
        List<Category> categories = categoryService.getAllCategories();
        return categories;
    }//check

    @PostMapping("/add")
    public Category addCategory(@RequestBody Map<String, String> NewCategory) {
        Category category= new Category();
        category.setName(NewCategory.get("name"));
        return categoryService.addCategory(category);
    }//check

    @GetMapping("/id/{id}")
    public Category getCategoryById(@PathVariable int id) {
        Category category = categoryService.getCategoryById(id);
        return category;
    }//check

    @GetMapping("/name/{name}")
    public Category getCategoryByName(@PathVariable String name) {
        Category category = categoryService.getCategoryByName(name);
        return category;
    }//check

    @DeleteMapping("/deleteCategory/{id}")
    public ResponseEntity<String> deleteCategory(@PathVariable int id) {
        Category category = categoryService.getCategoryById(id);
        categoryService.deleteCategory(category);
        return ResponseEntity.ok("Category deleted successfully");
    }


    
    
    
}

