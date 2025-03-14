package com.projeto.projeto.mappers;

import com.projeto.projeto.DTO.hospitalization.HospitalizationCreateDTO;
import com.projeto.projeto.models.HospitalModel;
import com.projeto.projeto.models.Hospitalization;
import com.projeto.projeto.models.PacientModel;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

import java.time.LocalDateTime;

@Mapper(componentModel = "spring")
public interface HospitalizationMapper {

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "hospitalizationDate", source = "data.hospitalizationDate")
    @Mapping(target = "hospitalizationExit", ignore = true)
    @Mapping(target = "hospitalizationReason", source = "data.hospitalizationReason")
    @Mapping(target = "pacientModel", source = "pacient")
    @Mapping(target = "hospitalModel", source = "hospital")
    @Mapping(target = "created", ignore = true)
    Hospitalization createHospitalization(HospitalizationCreateDTO data, PacientModel pacient, HospitalModel hospital);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "hospitalizationDate", ignore = true)
    @Mapping(target = "hospitalizationExit", source = "date")
    @Mapping(target = "hospitalizationReason", ignore = true)
    @Mapping(target = "pacientModel", ignore = true)
    @Mapping(target = "hospitalModel", ignore = true)
    @Mapping(target = "created", ignore = true)
    Hospitalization exitHospitalization(@MappingTarget Hospitalization hospitalization, LocalDateTime date);
}
