package com.projeto.projeto.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;
import java.util.UUID;

@Data
@Entity(name = "consultation")
@AllArgsConstructor
@NoArgsConstructor
public class Consultation {

    @Id
    @GeneratedValue(generator = "UUID")
    private UUID id;

    @Column(name = "consultation_date", nullable = false)
    private LocalDateTime consultationDate;

    @Column(name = "treatment_plan",nullable = false)
    private String treatmentPlan;

    @Column(nullable = false)
    private String diagnosed;

    @Column(nullable = false)
    private String symptoms;

    @ManyToOne
    @JoinColumn(name = "pacient_id")
    private PacientModel pacientModel;

    @ManyToOne
    @JoinColumn(name = "doctor_id")
    private DoctorModel doctorModel;

    @CreationTimestamp
    private LocalDateTime created;

}