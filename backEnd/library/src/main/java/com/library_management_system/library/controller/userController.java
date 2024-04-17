package com.library_management_system.library.controller;
import com.library_management_system.library.service.userService;
import com.library_management_system.library.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class userController {
    @Autowired
    private userService Service;
@PostMapping("/saveUser")
    public User saveUser(@RequestBody User user) {
        return Service.saveUser(user);
    }
    @GetMapping("/getUsers")
    public List<User> getUsers() {
        return Service.getUsers();
    }
    @GetMapping("/getUserById/{id}")
    public User getUserById(@PathVariable  int id) {
        return Service.getUserById(id);
    }
    @DeleteMapping("/deleteUserById/{id}")
    public String DeleteUserById(@PathVariable int id) {
        Service.DeleteUserById(id);
        return"deleted successfully !!"+id;
    }
    @PutMapping("/UpdateUser")
    public User UpdateUser(@RequestBody User user) {
        return Service.UpdateUser(user);
    }


}
