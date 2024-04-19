package com.library_management_system.library.service;

import com.library_management_system.library.entity.User;
import com.library_management_system.library.repository.userRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class userService {
@Autowired
    private userRepository Repository;

    public userService(userRepository Repository) {
        this.Repository = Repository;
    }

    public User saveUser(User user) {
        return Repository.save(user);
    }

    public List<User> getUsers() {
        return Repository.findAll();
    }

    public User getUserById(int id) {
        return Repository.findById(id).orElse(null);
    }

    public boolean getUserByusername(String username , String password) {
       User user = Repository.findByname(username);
       if(user == null) {
           return false;
       }
        return (user.getPassword().contentEquals(password));
    }

    public boolean checkUSerExist(String username) {
        User user = Repository.findByname(username);
        if(user == null) {
            return false;
        }
        return true;
    }


    public String DeleteUserById(int id) {
        Repository.deleteById(id);
        return "deleted successfully !!" + id;
    }

    public User UpdateUser(User user) {
        User existingUser = Repository.findById(user.getId()).orElse(null);
        existingUser.setId(user.getId());
        existingUser.setName(user.getName());
        existingUser.setEmail(user.getEmail());
        existingUser.setPassword(user.getPassword());
        existingUser.setAge(user.getAge());
        existingUser.setGender(user.getGender());
        existingUser.setPhone(user.getPhone());
        existingUser.setJob(user.getJob());
        existingUser.setUserRole(user.getUserRole());
        existingUser.setJoined(user.getJoined());
        return Repository.save(existingUser);

    }

}
