package com.projeto.projeto.models;

import jakarta.persistence.*;
import lombok.Data;

import java.util.UUID;

@Data
@Entity(name = "paciente")
public class PacientModel {

    @Id
    @GeneratedValue(generator = "UUID")
    private UUID id;

    @Column(name = "sex",nullable = false)
    private String sex;

    @Column(name = "health_plan",nullable = true)
    private String health_plan;

    @JoinColumn(name = "id_user")
}
