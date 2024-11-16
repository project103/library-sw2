package com.library_management_system.library.repository;
import com.library_management_system.library.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;


public interface CategoryRepository extends JpaRepository<Category, Integer> {
        
        Category findByName(String name);
        Category findById(int id);
    
}
