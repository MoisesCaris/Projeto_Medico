package com.projeto.projeto.DTO.consultation;

import java.time.LocalDateTime;
import java.util.UUID;

public record RegisterConsultationDTO(LocalDateTime consultationDate, String treatmentPlan, String diagnosed, String symptoms, UUID pacientID, UUID doctorID) {
}
