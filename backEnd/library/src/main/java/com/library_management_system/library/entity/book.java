package com.library_management_system.library.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class book {
    @Id
    int id;
    String name;
    String author;
    String description;
    int category_id;
    Float price;
    int copies;
    String format;
    int length;
    float rating;
    int edition;
    String language;
}
