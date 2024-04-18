package com.library_management_system.library.service;

import com.library_management_system.library.entity.Favorite;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.library_management_system.library.repository.FavoritesRepository;

import java.util.Collections;
import java.util.List;

@Service
public class FavoriteService {
    @Autowired
    private FavoritesRepository repo;

    public Favorite saveFavorite(Favorite favorite) {
        return repo.save(favorite);
    }

    public List<Favorite> getFavoritesByUserId(int userId) {
        return repo.findByUserId(userId);
    }
    public List<Favorite> getFavoritesByItemId(int ItemId) {
        return repo.findByProductId(ItemId);
    }


}
