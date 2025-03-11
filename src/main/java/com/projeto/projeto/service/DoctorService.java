package com.projeto.projeto.service;

import com.projeto.projeto.DTO.doctor.DoctorDependencies;
import com.projeto.projeto.DTO.doctor.DoctorRegisterDTO;
import com.projeto.projeto.DTO.pacient.PacientDependecies;
import com.projeto.projeto.DTO.pacient.PacientRegisterDTO;
import com.projeto.projeto.mappers.DoctorMapper;
import com.projeto.projeto.models.DoctorModel;
import com.projeto.projeto.repository.DoctorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class DoctorService {

    @Autowired
    private DoctorRepository doctorRepository;

    @Autowired
    private DoctorMapper mapper;

    @Autowired
    private UserService userService;

    public DoctorModel getDoctor(UUID id) {
        return doctorRepository.findById(id).orElse(null);
    }

    public List<DoctorModel> getAllDoctors() {
        return doctorRepository.findAll();
    }

    private DoctorDependencies getDoctorDependecies(DoctorRegisterDTO data) {
        return new DoctorDependencies(userService.getUser(data.userID()));
    }


    public void register(DoctorRegisterDTO data) {
        DoctorDependencies dependencies = getDoctorDependecies(data);

        DoctorModel doctor = mapper.doctorRegister(data, dependencies.userModels());
        this.doctorRepository.save(doctor);
    }
}
