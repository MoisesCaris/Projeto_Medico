package com.projeto.projeto.service;

import com.projeto.projeto.DTO.hospital.HospitalNameChangeDTO;
import com.projeto.projeto.DTO.hospital.RegisterHospitalDTO;
import com.projeto.projeto.mappers.HospitalMapper;
import com.projeto.projeto.models.HospitalModel;
import com.projeto.projeto.repository.HospitalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class HospitalService {
    @Autowired
    private HospitalRepository hospitalRepository;

    @Autowired
    private  HospitalMapper mapper;

    public HospitalModel getHospitalById(UUID id) {
        return hospitalRepository.findById(id).orElseThrow();
    }

    public HospitalNameChangeDTO hospitalNameChange(HospitalNameChangeDTO data, HospitalModel hospital, UUID id){
        HospitalModel existingHospital = getHospitalById(id);

        mapper.uptadeHospitalName(existingHospital, data);

        return mapper.toResponseDTO(existingHospital);
    }

    public Object hospitalNameChange(UUID id, HospitalNameChangeDTO data) {
        HospitalModel existingHospital = getHospitalById(id);

        mapper.uptadeHospitalName(existingHospital, data);

        return mapper.toResponseDTO(hospitalRepository.save(existingHospital));
    }
}
