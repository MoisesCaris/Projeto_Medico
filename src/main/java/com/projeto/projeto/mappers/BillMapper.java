package com.projeto.projeto.mappers;

import com.projeto.projeto.DTO.bill.CompletePayment;
import com.projeto.projeto.DTO.bill.RegisterBillDTO;
import com.projeto.projeto.models.Bill;
import com.projeto.projeto.models.PacientModel;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

import java.time.LocalDateTime;

@Mapper(componentModel = "spring")
public interface BillMapper {

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "paymentDate", ignore = true)
    @Mapping(target = "value", source = "data.value")
    @Mapping(target = "status", source = "data.status")
    @Mapping(target = "pacientModel", source = "pacient")
    @Mapping(target = "created", ignore = true)
    Bill billRegister(RegisterBillDTO data, PacientModel pacient);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "paymentDate", source = "date")
    @Mapping(target = "value", ignore = true)
    @Mapping(target = "status", source = "data.status")
    @Mapping(target = "pacientModel", ignore = true)
    @Mapping(target = "created", ignore = true)
    void completePayment(@MappingTarget Bill bill, CompletePayment data, LocalDateTime date);
}
