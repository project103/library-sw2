package com.library_management_system.library.controller;

import com.library_management_system.library.service.userService;
import com.library_management_system.library.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Map;

import static java.sql.DriverManager.println;

@RestController

@RequestMapping("/User")
public class userController {
    @Autowired
    private userService Service;

    @PostMapping("/Register")
    public ModelAndView registerUser(@RequestBody User user) {
        List<User> existingUsers = Service.findUsersByEmail(user.getEmail());
        if (!existingUsers.isEmpty()) {
            return new ModelAndView("redirect:/user/register.html");
        } else {
            Service.saveUser(user);
            return new ModelAndView("redirect:/user/signin.html");
        }
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
 public User login(@RequestBody Map<String,String> name) {
  Integer id =   Service.getUserByusername(name.get("name"),name.get("password"));
if (id != null){
    return Service.getUserById(id);}
else return null;
}
}