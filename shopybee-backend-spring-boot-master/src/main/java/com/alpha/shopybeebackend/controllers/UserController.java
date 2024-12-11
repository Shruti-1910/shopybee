package com.alpha.shopybeebackend.controllers;

import com.alpha.shopybeebackend.models.User;
import com.alpha.shopybeebackend.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping("shopybee/user")
@RestController
public class UserController {

    private final UserService service;

    @Autowired
    public UserController(UserService service) {
        this.service = service;
    }

    // Login endpoint: returns JWT token on successful login
    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody User user) {
        String token = service.login(user);  // JWT token returned from login method
        return new ResponseEntity<>(token, HttpStatus.OK);
    }

    // Register endpoint: register new user
    @PostMapping("/register")
    public ResponseEntity<User> register(@RequestBody User user) {
        return new ResponseEntity<>(service.registerNewUser(user), HttpStatus.OK);
    }

    // Get user by ID
    @GetMapping("/get-by-id/{id}")
    public ResponseEntity<User> getById(@PathVariable Long id) {
        return new ResponseEntity<>(service.getById(id), HttpStatus.OK);
    }
}
