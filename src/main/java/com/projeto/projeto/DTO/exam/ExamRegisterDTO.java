package com.projeto.projeto.DTO.exam;

import java.time.LocalDateTime;
import java.util.UUID;

public record ExamRegisterDTO(LocalDateTime realizationDate, String result, String examType, UUID pacientID, UUID consultationID) {
}
