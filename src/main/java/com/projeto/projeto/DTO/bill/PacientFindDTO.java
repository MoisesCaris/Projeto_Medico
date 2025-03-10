package com.projeto.projeto.DTO.bill;

import java.time.LocalDateTime;

public record PacientFindDTO(String name, String email, String fone, String cpf, String sex, String healthPlan, Double value, LocalDateTime paymentDay, String Status) {
}
