package com.library_management_system.library.repository;

import com.library_management_system.library.entity.Review;
import com.library_management_system.library.entity.Suggestion;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReviewRepository extends JpaRepository<Review, Integer> {

    // You can add more custom query methods as needed
}
