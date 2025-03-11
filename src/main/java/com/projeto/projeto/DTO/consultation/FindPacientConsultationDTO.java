package com.projeto.projeto.DTO.consultation;

import java.time.LocalDateTime;

public record FindPacientConsultationDTO(String name, String email, String fone, String cpf, String sex, String healthPlan, LocalDateTime consultationDate, String TreatmentPlans, String diagnosed, String symptoms, String doctorName, String specialty) {
}
