package com.projeto.projeto.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;
import java.util.UUID;

@Data
@Entity(name = "prescription")
@AllArgsConstructor
@NoArgsConstructor
public class Prescription {

    @Id
    @GeneratedValue(generator = "UUID")
    private UUID id;

    @Column(nullable = false)
    private String medicine;

    @Column(nullable = false)
    private String dosage;

    @ManyToOne
    @JoinColumn(name = "pacient_id")
    private PacientModel pacientModel;

    @ManyToOne
    @JoinColumn(name = "consultation_id")
    private Consultation consultation;

    @CreationTimestamp
    private LocalDateTime created;
}