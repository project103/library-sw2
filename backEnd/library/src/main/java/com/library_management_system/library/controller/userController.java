package com.library_management_system.library.controller;

import com.library_management_system.library.service.userService;
import com.library_management_system.library.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/user")
public class userController {
    @Autowired
    private userService Service;

    @PostMapping("saveUser")
    public ModelAndView saveUser(String user_name, String email, String phone, String password, String password_2, String Gender) {
        User user = new User();
        user.setEmail(email);
        user.setGender(Gender);
        user.setName(user_name);
        user.setPhone(phone);
        user.setPassword(password);
        boolean result= Service.checkUSerExist(user_name);
        if(result){
            return new ModelAndView("redirect:/user/register.html");
        }
        Service.saveUser(user);
        return new ModelAndView("redirect:/user/signin.html");
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
    public ModelAndView login(String username, String password) {
         boolean result= Service.getUserByusername(username, password);
       if(result){
           return new ModelAndView("redirect:/user/main.html");
       }
       else {
           return new ModelAndView("redirect:/user/signin.html");
       }
    }
}