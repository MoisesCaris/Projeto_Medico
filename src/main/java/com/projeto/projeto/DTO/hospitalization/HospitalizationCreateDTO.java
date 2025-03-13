package com.projeto.projeto.DTO.hospitalization;

import java.time.LocalDateTime;
import java.util.UUID;

public record HospitalizationCreateDTO(LocalDateTime hospitalizationDate, String hospitalizationReason, UUID pacientID, UUID hospitalID) {
}
