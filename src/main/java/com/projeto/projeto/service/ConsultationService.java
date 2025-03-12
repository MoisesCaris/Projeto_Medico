package com.projeto.projeto.service;

import com.projeto.projeto.DTO.consultation.ConsultationDependecies;
import com.projeto.projeto.DTO.consultation.FindPacientConsultationDTO;
import com.projeto.projeto.DTO.consultation.RegisterConsultationDTO;
import com.projeto.projeto.mappers.ConsultationMapper;
import com.projeto.projeto.models.Consultation;
import com.projeto.projeto.repository.ConsultationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class ConsultationService {

    @Autowired
    private ConsultationRepository consultationRepository;

    @Autowired
    private DoctorService doctorService;

    @Autowired
    private PacientService pacientService;

    @Autowired
    private ConsultationMapper mapper;

    private ConsultationDependecies featchConsultationDependecies(RegisterConsultationDTO data){
    return new ConsultationDependecies(doctorService.getDoctor(data.doctorID()), pacientService.getPacient(data.pacientID()));
    }

    public void register(RegisterConsultationDTO data) {
        ConsultationDependecies dependecies = featchConsultationDependecies(data);

        Consultation newConsultation = mapper.consultationRegister(data, dependecies.doctorModel(),dependecies.pacientModel());
        consultationRepository.save(newConsultation);
    }

    public Consultation getConsultation(UUID id) {
        return consultationRepository.findById(id).orElseThrow();
    }

    public List<Consultation> getConsultations() {
        return consultationRepository.findAll();
    }

    public List<FindPacientConsultationDTO> getConsultationsByPacient(UUID pacientID) {
        return consultationRepository.findByPacientID(pacientID);
    }

    public List<FindPacientConsultationDTO> getConsultationsByDoctor(UUID doctorID) {
        return consultationRepository.findByDoctorID(doctorID);
    }
}
