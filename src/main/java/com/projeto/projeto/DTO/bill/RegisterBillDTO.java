package com.projeto.projeto.DTO.bill;

import java.time.LocalDateTime;
import java.util.UUID;

public record RegisterBillDTO(Double value, String status, UUID pacientID) {
}
