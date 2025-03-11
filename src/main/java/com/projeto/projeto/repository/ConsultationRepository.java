package com.projeto.projeto.repository;

import com.projeto.projeto.DTO.consultation.FindPacientConsultationDTO;
import com.projeto.projeto.models.Consultation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.UUID;

public interface ConsultationRepository extends JpaRepository<Consultation, UUID> {

    @Query("SELECT new com.projeto.projeto.DTO.consultation.FindPacientConsultationDTO(u.name, u.email, u.fone, u.cpf, " +
            "p.sex, p.healthPlan, c.consultationDate, c.treatmentPlan, c.diagnosed, c.symptoms, u2.name, d.specialty) " +
            "FROM consultation c " +
            "JOIN c.pacientModel p " +
            "JOIN p.userModel u " +
            "JOIN c.doctorModel d " +
            "JOIN d.userModel u2 " +
            "WHERE p.id = :pacientID")
    List<FindPacientConsultationDTO> findByPacientID(UUID pacientID);
}
