package com.projeto.projeto.repository;

import com.projeto.projeto.DTO.bill.PacientFindDTO;
import com.projeto.projeto.models.Bill;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.UUID;

public interface BillRepository extends JpaRepository<Bill, UUID> {

    @Query("SELECT new com.projeto.projeto.DTO.bill.PacientFindDTO(u.name, u.email, u.fone, u.cpf, " +
            "p.sex, p.healthPlan, b.value, b.paymentDate, b.status) " +
            "FROM bill b " +
            "JOIN b.pacientModel p " +
            "JOIN p.userModel u " +
            "WHERE p.id = :pacientID")
    List<PacientFindDTO> findByPacient(UUID pacientID);

    @Query("SELECT new com.projeto.projeto.DTO.bill.PacientFindDTO(u.name, u.email, u.fone, u.cpf, " +
            "p.sex, p.healthPlan, b.value, b.paymentDate, b.status) " +
            "FROM bill b " +
            "JOIN b.pacientModel p " +
            "JOIN p.userModel u " +
            "WHERE p.id = :pacientID AND b.status is null ")
    List<PacientFindDTO> findStatusOpen(UUID pacientID);

    @Query("SELECT new com.projeto.projeto.DTO.bill.PacientFindDTO(u.name, u.email, u.fone, u.cpf, " +
            "p.sex, p.healthPlan, b.value, b.paymentDate, b.status) " +
            "FROM bill b " +
            "JOIN b.pacientModel p " +
            "JOIN p.userModel u " +
            "WHERE p.id = :pacientID AND b.status is not null ")
    List<PacientFindDTO> findStatusClose(UUID pacientID);
}