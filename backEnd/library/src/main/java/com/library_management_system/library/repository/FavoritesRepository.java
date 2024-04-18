package com.library_management_system.library.repository;

import com.library_management_system.library.entity.Favorite;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FavoritesRepository extends JpaRepository<Favorite,Integer> {
    List<Favorite> findByUserId(int userId);
    List<Favorite> findByProductId(int productId);
    // You can add more custom query methods as needed
}
