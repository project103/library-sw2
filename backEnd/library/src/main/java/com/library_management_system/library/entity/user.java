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

public class user  {
    @Id
    int id;
    String name;
    int age;
    int gender;
    String email;
    String password;
    int phone;
    String joined;
    String job;
    int user_role;


}
