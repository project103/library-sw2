package com.library_management_system.library.service;

import com.library_management_system.library.entity.User;
import com.library_management_system.library.repository.userRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import java.util.Optional;


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

    public Integer getUserByusername(String username , String password) {
       User user = Repository.findByname(username);
       if(user == null) {
           return null;
       }if(user.getPassword().contentEquals(password))
           return user.getId();
       else
            return null;
    }

    public boolean checkUSerExist(String username) {
        User user = Repository.findByname(username);
        if(user == null) {
            return false;
        }
        return true;
    }
    public List<User> findUsersByEmail(String email) {
        return Repository.findByEmail(email);
    }



    public String DeleteUserById(int id) {
        Repository.deleteById(id);
        return "deleted successfully !!" + id;
    }

    /*public User UpdateUser(Integer userId, User user) {
        User existingUser = Repository.findById(user.getId()).orElse(null);

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

    }*/


    public User updateUser(Integer userId, User updatedUser) {
        // Find the user by the provided userId
        Optional<User> optionalUser = Repository.findById(userId);

        if (optionalUser.isPresent()) {
            // Get the existing user
            User existingUser = optionalUser.get();

            // Update the existing user data with the data from the updatedUser
            existingUser.setName(updatedUser.getName());
            existingUser.setEmail(updatedUser.getEmail());
            existingUser.setPassword(updatedUser.getPassword());
            existingUser.setAge(updatedUser.getAge());
            existingUser.setGender(updatedUser.getGender());
            existingUser.setPhone(updatedUser.getPhone());
            existingUser.setJob(updatedUser.getJob());
            existingUser.setUserRole(updatedUser.getUserRole());
            existingUser.setJoined(updatedUser.getJoined());

            // Save the updated user and return
            return Repository.save(existingUser);
        } else {
            // Handle the case where no user with the provided ID is found
            // You can throw an exception, return null, or handle it based on your application's requirements
            return null;
        }
    }



}
