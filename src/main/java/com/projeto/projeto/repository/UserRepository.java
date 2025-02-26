package com.projeto.projeto.repository;

import com.projeto.projeto.models.UserModels;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.UUID;

public interface UserRepository extends JpaRepository<UserModels, UUID> {
    UserDetails findByEmail(String email);
}
