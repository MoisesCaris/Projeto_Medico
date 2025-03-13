package com.projeto.projeto.repository;

import com.projeto.projeto.models.Hospitalization;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface HospitalizationRepository extends JpaRepository<Hospitalization, UUID> {
}
