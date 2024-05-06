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

    public String getName() {
        return name;
    }

    public Integer getAge() {
        return age;
    }

    public String getGender() {
        return gender;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setProfilePic(String profilePic) {
        this.profilePic = profilePic;
    }

    public void setUserRole(Integer userRole) {
        this.userRole = 0;
    }

    public Integer getUserRole() {
        return userRole;
    }

    public void setId(int id) {
        this.id = id;
    }
}
