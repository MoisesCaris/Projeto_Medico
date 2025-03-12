package com.projeto.projeto.DTO.exam;

import java.time.LocalDateTime;

public record FindExamDTO(String paciente, String fone, String sex, String healthPlan, LocalDateTime realizationDate, String result, String examType) {
}
