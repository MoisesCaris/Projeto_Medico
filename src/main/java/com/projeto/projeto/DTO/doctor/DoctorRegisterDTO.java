package com.projeto.projeto.DTO.doctor;

import java.util.UUID;

public record DoctorRegisterDTO(String crm, String specialty, UUID userID) {
}
