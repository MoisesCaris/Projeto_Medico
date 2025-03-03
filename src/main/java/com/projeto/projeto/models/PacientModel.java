package com.projeto.projeto.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@Entity(name = "pacient")
@AllArgsConstructor
@NoArgsConstructor
public class PacientModel {

    @Id
    @GeneratedValue(generator = "UUID")
    private UUID id;

    @Column(name = "sex",nullable = false)
    private String sex;

    @Column(name = "health_plan",nullable = true)
    private String healthPlan;

    @OneToOne
    @JoinColumn(name = "id_user")
    private UserModels userModel;
}
