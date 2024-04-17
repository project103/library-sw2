package com.library_management_system.library.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;
    private Integer age;
    private String gender;
    private String email;
    private String password;
    private String phone;
    private String profilePic;
    private String joined;
    private String job;
    private Integer userRole;

    // Getters and setters
}
