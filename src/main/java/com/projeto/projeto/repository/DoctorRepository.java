package com.projeto.projeto.repository;

import com.projeto.projeto.models.DoctorModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface DoctorRepository extends JpaRepository<DoctorModel, UUID> {
}
