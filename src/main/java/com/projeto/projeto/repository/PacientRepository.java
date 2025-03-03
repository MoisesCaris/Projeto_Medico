package com.projeto.projeto.repository;

import com.projeto.projeto.models.PacientModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface PacientRepository extends JpaRepository<PacientModel, UUID> {
}
