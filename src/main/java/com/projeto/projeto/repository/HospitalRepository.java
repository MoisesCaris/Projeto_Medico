package com.projeto.projeto.repository;

import com.projeto.projeto.models.HospitalModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface HospitalRepository extends JpaRepository<HospitalModel, UUID> {
    List<HospitalModel> findByName(String name);

    List<HospitalModel> findAllByCity(String city);

    List<HospitalModel> findAllByState(String state);
}
