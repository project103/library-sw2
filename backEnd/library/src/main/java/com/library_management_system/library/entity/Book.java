package com.library_management_system.library.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity

public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;
    private String author;
    private String description;

    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;

    private double price;
    private int copies;
    private String format;
    private Integer length;
    private Double rating;
    private String edition;
    private String language;

    // Getters and setters
}
