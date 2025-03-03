package com.projeto.projeto.service;

import com.projeto.projeto.models.UserModels;
import com.projeto.projeto.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public UserModels getUser(UUID id) {
        return userRepository.findById(id).orElseThrow();
    }

    public List<UserModels> getAllUsers() {
        return userRepository.findAll();
    }
}
