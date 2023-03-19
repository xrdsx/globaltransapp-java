package com.globaltransapp.globaltransappbackend.controller;

import com.globaltransapp.globaltransappbackend.exception.UserNotFoundException;
import com.globaltransapp.globaltransappbackend.model.User;

import com.globaltransapp.globaltransappbackend.model.UserRole;
import com.globaltransapp.globaltransappbackend.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://127.0.0.1:5500")
public class UserController {

    @Autowired
    private UserRepository userRepository;




    @PostMapping("/user")
    public User addUser(@RequestBody User newUser) {

        return userRepository.save(newUser);
    }


    @GetMapping("/users")
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }


    @GetMapping("/user/{id}")
    public User getUserById(@PathVariable Long id) {
        return userRepository.findById(id)
                .map(user -> {
                    user.getRole(); // pobranie roli
                    return user;
                })
                .orElseThrow(() -> new UserNotFoundException(id));
    }


    @PutMapping("/user/{id}")
    public User updateUser(@RequestBody User newUser, @PathVariable Long id) {
        return userRepository.findById(id)
                .map(user -> {
                    user.setUsername(newUser.getUsername());
                    user.setPassword(newUser.getPassword());
                    user.setRole(newUser.getRole());
                    return userRepository.save(user);
                })
                .orElseThrow(() -> new UserNotFoundException(id));
    }


    @DeleteMapping("/user/{id}")
    public String deleteUser(@PathVariable Long id) {
        if (!userRepository.existsById(id)) {
            throw new UserNotFoundException(id);
        }
        userRepository.deleteById(id);
        return "User with ID " + id + " has been deleted.";
    }
}