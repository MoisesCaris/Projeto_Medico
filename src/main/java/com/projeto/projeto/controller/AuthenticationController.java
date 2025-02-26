package com.projeto.projeto.controller;

import com.projeto.projeto.DTO.AuthenticationDTO;
import com.projeto.projeto.DTO.RegisterDTO;
import com.projeto.projeto.models.UserModels;
import com.projeto.projeto.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthenticationController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private AuthenticationManager authenticationManager;

    @PostMapping("/login")
    public ResponseEntity login(@RequestBody AuthenticationDTO authenticationDTO) {
        var userPassword = new UsernamePasswordAuthenticationToken(authenticationDTO.email(), authenticationDTO.password());
        var auth = this.authenticationManager.authenticate(userPassword);

        return ResponseEntity.ok().build();
    }

    @PostMapping("/register")
    public ResponseEntity register(@RequestBody RegisterDTO registerDTO) {
    if (userRepository.findByEmail(registerDTO.email()) == null) {
        var encryptedPassword = new BCryptPasswordEncoder().encode(registerDTO.password());
        var user = new UserModels(registerDTO.name(), registerDTO.email(), encryptedPassword, registerDTO.fone(), registerDTO.cpf(), registerDTO.role());
        this.userRepository.save(user);
        return ResponseEntity.ok().build();
    }else {
        return ResponseEntity.badRequest().build();
    }
    }
}
