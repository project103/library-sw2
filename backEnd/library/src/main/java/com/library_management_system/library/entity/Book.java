package com.library_management_system.library.entity;

import org.springframework.beans.factory.annotation.Autowired;

import com.library_management_system.library.repository.BookRepository;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity

public class Book {
    public Book(Integer id) {
        this.id = id;
    }


    public Book(String name, String author, String description, Integer price, Integer copies, String format,
            Integer length, Double rating, String edition, String language , String pic) {
        this.name = name;
        this.author = author;
        this.description = description;
        this.price = price;
        this.copies = copies;
        this.format = format;
        this.length = length;
        this.rating = rating;
        this.edition = edition;
        this.language = language;
        this.Pic = pic;
    }



    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;
    private String author;
    private String description;

    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;

    private Integer price;
    private Integer copies;
    private String format;
    private Integer length;
    private Double rating;
    private String edition;
    private String language;
    private String Pic;

    // Getters and setters
}
