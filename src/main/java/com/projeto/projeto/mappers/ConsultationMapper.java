package com.projeto.projeto.mappers;

import com.projeto.projeto.DTO.consultation.RegisterConsultationDTO;
import com.projeto.projeto.models.Consultation;
import com.projeto.projeto.models.DoctorModel;
import com.projeto.projeto.models.PacientModel;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface ConsultationMapper {

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "consultationDate", source = "data.consultationDate")
    @Mapping(target = "treatmentPlan", source = "data.treatmentPlan")
    @Mapping(target = "diagnosed", source = "data.diagnosed")
    @Mapping(target = "symptoms", source = "data.symptoms")
    @Mapping(target = "pacientModel", source = "pacient")
    @Mapping(target = "doctorModel", source = "doctor")
    @Mapping(target = "created", ignore = true)
    Consultation consultationRegister(RegisterConsultationDTO data, DoctorModel doctor, PacientModel pacient);
}
