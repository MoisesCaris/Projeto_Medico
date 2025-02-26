package com.projeto.projeto.models;

import jakarta.persistence.*;
import lombok.Data;

import java.util.UUID;

@Data
@Entity(name = "doctor")
public class DoctorModel {

    @Id
    @GeneratedValue(generator = "UUID")
    private UUID id;

    @Column(unique = true, nullable = false)
    private String crm;

    @Column(nullable = false)
    private String specialty;
}
