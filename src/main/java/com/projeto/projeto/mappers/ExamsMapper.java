package com.projeto.projeto.mappers;

import com.projeto.projeto.DTO.exam.ExamRegisterDTO;
import com.projeto.projeto.models.Consultation;
import com.projeto.projeto.models.Exams;
import com.projeto.projeto.models.PacientModel;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface ExamsMapper {

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "realizationDate", source = "data.realizationDate")
    @Mapping(target = "result", source = "data.result")
    @Mapping(target = "examType", source = "data.examType")
    @Mapping(target = "pacientModel", source = "pacient")
    @Mapping(target = "consultation", source = "consultation")
    @Mapping(target = "created", ignore = true)
    Exams examRegister(ExamRegisterDTO data, PacientModel pacient, Consultation consultation);
}
