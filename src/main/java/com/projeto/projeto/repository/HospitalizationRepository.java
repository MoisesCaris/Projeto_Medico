package com.projeto.projeto.repository;

import com.projeto.projeto.DTO.hospitalization.FindHospitalizationDTO;
import com.projeto.projeto.models.Hospitalization;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.UUID;

public interface HospitalizationRepository extends JpaRepository<Hospitalization, UUID> {

    @Query("select new com.projeto.projeto.DTO.hospitalization.FindHospitalizationDTO(h.hospitalizationDate, h.hospitalizationReason, u.name, u.email, u.fone, u.cpf, p.sex, p.healthPlan, ho.name, ho.address, ho.city, ho.state) " +
            "from hospitalization h " +
            "join h.pacientModel p " +
            "join h.hospitalModel ho " +
            "join p.userModel u " +
            "where ho.name = :hospitalName and h.hospitalizationExit is null ")
    List<FindHospitalizationDTO> findHospitalizationByHospitalName(String hospitalName);
}
