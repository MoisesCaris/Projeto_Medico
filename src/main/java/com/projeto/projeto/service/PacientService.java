package com.projeto.projeto.service;

import com.projeto.projeto.DTO.pacient.PacientDependecies;
import com.projeto.projeto.DTO.pacient.PacientRegisterDTO;
import com.projeto.projeto.mappers.PacientMapper;
import com.projeto.projeto.models.PacientModel;
import com.projeto.projeto.repository.PacientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class PacientService {

    @Autowired
    private PacientRepository pacientRepository;

    @Autowired
    private PacientMapper mapper;

    @Autowired
    private UserService userService;

    public PacientModel getPacient(UUID id) {
        return pacientRepository.findById(id).orElseThrow();
    }

    private PacientDependecies getPacientDependecies(PacientRegisterDTO data) {
        return new PacientDependecies(userService.getUser(data.userID()));
    }

    public void registerPacient(PacientRegisterDTO data) {
        PacientDependecies dependecies = getPacientDependecies(data);

        PacientModel pacientModel = mapper.registerPacient(data, dependecies.userModels());

        this.pacientRepository.save(pacientModel);
    }

    public List<PacientModel> getAllPacients() {
        return pacientRepository.findAll();
    }
}
