package com.projeto.projeto.controller;

import com.projeto.projeto.models.UserModels;
import com.projeto.projeto.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping("/get/users")
    public ResponseEntity registerUser() {
        return ResponseEntity.status(HttpStatus.OK).body(userService.getAllUsers());
    }
}
