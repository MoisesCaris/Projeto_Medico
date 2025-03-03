package com.projeto.projeto.mappers;

import com.projeto.projeto.DTO.pacient.PacientRegisterDTO;
import com.projeto.projeto.models.PacientModel;
import com.projeto.projeto.models.UserModels;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface PacientMapper {

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "sex", source = "data.sex")
    @Mapping(target = "healthPlan", source = "data.healthPlan")
    @Mapping(target = "userModel", source = "user")
    PacientModel registerPacient(PacientRegisterDTO data, UserModels user);
}
