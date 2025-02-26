package com.projeto.projeto.DTO;

import com.projeto.projeto.models.UserRole;

public record RegisterDTO(String name, String cpf, String email, String password, UserRole role, String fone) {
}
