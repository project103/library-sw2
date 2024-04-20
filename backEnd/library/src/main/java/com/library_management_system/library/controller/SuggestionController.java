package com.library_management_system.library.controller;
import org.springframework.http.ResponseEntity;
import com.library_management_system.library.service.suggestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.*;
@RestController
public class SuggestionController {
    @Autowired
    private suggestionService suggestionService;

    @GetMapping("/suggestions/{userId}")
    public ResponseEntity<List<String>> getSuggestions(@PathVariable String userId) {
        List<String> suggestions = suggestionService.suggestBooks(userId);
        return ResponseEntity.ok(suggestions);
    }
}
