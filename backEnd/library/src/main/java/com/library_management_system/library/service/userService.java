package com.library_management_system.library.service;
import com.library_management_system.library.entity.user;
import com.library_management_system.library.repository.userRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class userService {

    private userRepository Repository;

    public user saveUser(user user) {
        return Repository.save(user);
    }
    public List<user> getUsers() {
        return Repository.findAll();
    }
    public user getUserById(int id) {
        return Repository.findById(id).orElse(null);
    }
    public String DeleteUserById(int id) {
         Repository.deleteById(id);
         return"deleted successfully !!"+id;
    }
    public user UpdateUser(user user) {
        user existingUser =  Repository.findById(user.getId()).orElse(null);
        existingUser.setId(user.getId());
        existingUser.setName(user.getName());
        existingUser.setEmail(user.getEmail());
        existingUser.setPassword(user.getPassword());
        existingUser.setAge(user.getAge());
        existingUser.setGender(user.getGender());
        existingUser.setPhone(user.getPhone());
        existingUser.setJob(user.getJob());
        existingUser.setUser_role(user.getUser_role());
        existingUser.setJoined(user.getJoined());
        return Repository.save(existingUser);

    }


}
