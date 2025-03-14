package com.projeto.projeto.DTO.hospitalization;

import java.time.LocalDateTime;

public record FindHospitalizationDTO(LocalDateTime hospitalizationDate, String hospitalizationReason,String name, String email, String fone, String cpf, String sex, String healthPlan, String hospitalName, String address, String city, String state) {
}
