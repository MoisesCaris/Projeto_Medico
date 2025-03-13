package com.projeto.projeto.service;

import com.projeto.projeto.DTO.hospitalization.HospitalizationCreateDTO;
import com.projeto.projeto.DTO.hospitalization.HospitalizationDependecies;
import com.projeto.projeto.mappers.HospitalizationMapper;
import com.projeto.projeto.models.Hospitalization;
import com.projeto.projeto.repository.HospitalizationRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;
import java.util.UUID;

@Service
@AllArgsConstructor
public class HospitalizationService {

    @Autowired
    private HospitalizationRepository hospitalizationRepository;

    @Autowired
    private PacientService pacientService;

    @Autowired
    private HospitalizationRepository repository;

    @Autowired
    private HospitalService hospitalService;

    @Autowired
    private HospitalizationMapper mapper;

    private HospitalizationDependecies getHospitalizationDependecies(HospitalizationCreateDTO data) {
        return new HospitalizationDependecies(pacientService.getPacient(data.pacientID()), hospitalService.getHospitalById(data.hospitalID()));
    }

    public void createHospitalization(HospitalizationCreateDTO data) {
        HospitalizationDependecies dependecies = getHospitalizationDependecies(data);

        Hospitalization hospitalization = mapper.createHospitalization(data, dependecies.pacientModel(), dependecies.hospitalModel());

        this.repository.save(hospitalization);
    }

    public Hospitalization getHospitalization(UUID id) {
        return hospitalizationRepository.findById(id).orElseThrow();
    }

    public Object endHospitalization(UUID id) {
        var date = LocalDateTime.now();
        Hospitalization existingHospitalzation = getHospitalization(id);
        mapper.exitHospitalization(date);
        return repository.save(existingHospitalzation);
    }
}
