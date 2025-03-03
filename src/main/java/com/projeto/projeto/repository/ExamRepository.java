package com.projeto.projeto.repository;


import com.projeto.projeto.models.Exams;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ExamRepository extends JpaRepository<Exams, UUID> {
}
