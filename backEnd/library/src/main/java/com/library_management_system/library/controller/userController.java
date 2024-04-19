package com.library_management_system.library.controller;

import com.library_management_system.library.service.userService;
import com.library_management_system.library.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.Map;

@RestController
@CrossOrigin(origins = "http://localhost:63342")
@RequestMapping("/user")
public class userController {
    @Autowired
    private userService Service;

    @PostMapping("/saveUser")
    public User saveUser(@RequestBody User user) {
        return Service.saveUser(user);
    }

    @GetMapping("")
    public String test() {
        return "hello";
    }

    @GetMapping("/getUsers")
    public List<User> getUsers() {
        return Service.getUsers();
    }

    @GetMapping("/getUserById/{id}")
    public User getUserById(@PathVariable int id) {
        return Service.getUserById(id);
    }

    @DeleteMapping("/{id}/deleteByid")
    public String DeleteUserById(@PathVariable int id) {
        Service.DeleteUserById(id);
        return "deleted successfully !!" + id;
    }

    @PutMapping("/UpdateUser")
    public User UpdateUser(@RequestBody User user) {
        return Service.UpdateUser(user);
    }
@PostMapping("/login")
 public boolean login(@RequestBody Map<String,String> name) {
    return Service.getUserByusername(name.get("name"),name.get("password"));
}
}