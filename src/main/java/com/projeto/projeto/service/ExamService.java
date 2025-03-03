package com.projeto.projeto.service;

import com.projeto.projeto.DTO.exam.ExamDependecies;
import com.projeto.projeto.DTO.exam.ExamRegisterDTO;
import com.projeto.projeto.mappers.ExamsMapper;
import com.projeto.projeto.models.Exams;
import com.projeto.projeto.repository.ExamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class ExamService {

    @Autowired
    private ConsultationService consultationService;

    @Autowired
    private PacientService pacientService;

    @Autowired
    private ExamsMapper mapper;

    @Autowired
    private ExamRepository examRepository;

    private ExamDependecies getExamDependecies(ExamRegisterDTO data) {
        return new ExamDependecies(pacientService.getPacient(data.pacientID()), consultationService.getConsultation(data.consultationID()));
    }

    public void examRegister(ExamRegisterDTO data) {
        ExamDependecies dependecies = getExamDependecies(data);

        Exams exam = mapper.examRegister(data, dependecies.pacientModel(), dependecies.consultation());

        this.examRepository.save(exam);
    }

    public Exams getExam(UUID id) {
        return examRepository.findById(id).orElseThrow();
    }
}
