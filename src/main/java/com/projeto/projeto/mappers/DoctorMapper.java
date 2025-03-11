package com.projeto.projeto.mappers;

import com.projeto.projeto.DTO.doctor.DoctorRegisterDTO;
import com.projeto.projeto.models.DoctorModel;
import com.projeto.projeto.models.UserModels;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface DoctorMapper {

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "crm", source = "data.crm")
    @Mapping(target = "specialty", source = "data.specialty")
    @Mapping(target = "userModel", source = "user")
    DoctorModel doctorRegister(DoctorRegisterDTO data, UserModels user);
}
