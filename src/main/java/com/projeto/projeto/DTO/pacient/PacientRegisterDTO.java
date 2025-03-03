package com.projeto.projeto.DTO.pacient;

import java.util.UUID;

public record PacientRegisterDTO(String sex, String healthPlan, UUID userID) {
}
