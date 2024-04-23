package com.library_management_system.library.repository;
import com.library_management_system.library.entity.Suggestion;
import com.library_management_system.library.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SuggestionRepository extends JpaRepository<Suggestion, Integer> {
    List<Suggestion> findByUser(User user);
}
