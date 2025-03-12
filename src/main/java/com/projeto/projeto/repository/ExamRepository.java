package com.projeto.projeto.repository;


import com.projeto.projeto.DTO.exam.FindExamDTO;
import com.projeto.projeto.models.Exams;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.UUID;

public interface ExamRepository extends JpaRepository<Exams, UUID> {
    @Query("select new com.projeto.projeto.DTO.exam.FindExamDTO(" +
            "u.name, u.fone, p.sex, p.healthPlan, e.realizationDate, e.result, e.examType )" +
            "from exam e " +
            "join e.pacientModel p " +
            "join p.userModel u " +
            "where p.id = :pacientID ")
    List<FindExamDTO> findByPacient(UUID pacientID);
}
