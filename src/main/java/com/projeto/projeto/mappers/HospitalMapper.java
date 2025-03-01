package com.projeto.projeto.mappers;

import com.projeto.projeto.DTO.hospital.HospitalNameChangeDTO;
import com.projeto.projeto.DTO.hospital.RegisterHospitalDTO;
import com.projeto.projeto.models.HospitalModel;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

@Mapper (componentModel = "spring")
public interface HospitalMapper {

    @Mapping(source = "id", target = "id")
    HospitalNameChangeDTO toResponseDTO(HospitalModel hospitalModel);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "name", source = "data.name")
    @Mapping(target = "address", ignore = true)
    @Mapping(target = "city", ignore = true)
    @Mapping(target = "state", ignore = true)
    void uptadeHospitalName(@MappingTarget HospitalModel hospital, HospitalNameChangeDTO data);

    @Mapping(source = "city", target = "city")
    RegisterHospitalDTO toFindDTO(HospitalModel hospital);
}
