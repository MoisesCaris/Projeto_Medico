package com.projeto.projeto.controller;

import com.projeto.projeto.models.UserModels;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class UserController {

    @PostMapping("/registeruser")
    public ResponseEntity<String> registerUser(@RequestBody UserModels userModel) {
        return ResponseEntity.ok().body("User registered successfully");
    }
}
