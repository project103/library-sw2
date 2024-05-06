package com.library_management_system.library.entity;

import jakarta.persistence.*;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "user")
public class User {
@Valid

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private int id;

    @NotNull(message = "name is mandatory")
    @NotBlank(message = "name is mandatory")
    private String name;

    private Integer age;

    @NotNull(message = "gender is mandatory")
    @NotBlank(message = "gender is mandatory")
    private String gender;


    @NotNull(message = "email is mandatory")
    @NotBlank(message = "email is mandatory")
    private String email;

    @NotNull(message = "password is mandatory")
    @NotBlank(message = "password is mandatory")
    @Size(min=6 , max = 200 )
    private String password;

    @NotNull(message = "phone is mandatory")
    @NotBlank(message = "phone is mandatory")
    @Size(min=11 , max = 11 )

    private String phone;
    private String profilePic;
    private String joined;
    private String job;
    private Integer userRole;

    // Getters and setters


}
