package com.library_management_system.library.controller;

import com.library_management_system.library.entity.Favorite;
import com.library_management_system.library.service.FavoriteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Favorite")
public class FavoriteController {
    @Autowired
    private FavoriteService Service;
@PostMapping("/SavaFavorite")
    public Favorite saveFavorite(@RequestBody Favorite favorite) {
        return Service.saveFavorite(favorite);
    }
@GetMapping("/GetByUserId")
    public List<Favorite> getFavoritesByUserId(@PathVariable int userId) {
        return Service.getFavoritesByUserId(userId);
    }
    @GetMapping("/GetByItemId/{ItemId}")
    public List<Favorite> getFavoritesByItemId(@PathVariable int ItemId) {
        return Service.getFavoritesByItemId(ItemId);
    }}
