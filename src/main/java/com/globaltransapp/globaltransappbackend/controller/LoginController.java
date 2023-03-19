package com.globaltransapp.globaltransappbackend.controller;

import ch.qos.logback.core.model.Model;
import com.globaltransapp.globaltransappbackend.model.User;
import com.globaltransapp.globaltransappbackend.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller

public class LoginController {

    @Autowired
    private UserRepository userRepository;
    @GetMapping("templates/login.html")
    public String showLoginForm() {
        return "login";
    }

    @PostMapping("/login")
    public String login(@RequestParam String username, @RequestParam String password, Model model) {
        // Sprawdzenie autentykacji użytkownika w bazie danych
        if (userRepository.findByUsername(username).isPresent() &&
                userRepository.findByUsername(username).get().getPassword().equals(password)) {
            return "redirect:/home";
        } else {

            return "login";
        }
    }

}