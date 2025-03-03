package com.projeto.projeto.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;
import java.util.UUID;

@Data
@Entity(name = "exam")
@AllArgsConstructor
@NoArgsConstructor
public class Exams {

    @Id
    @GeneratedValue(generator = "UUID")
    private UUID id;

    @Column(name = "realization_date", nullable = false)
    private LocalDateTime realizationDate;

    @Column(nullable = false)
    private String result;

    @Column(name = "exam_tyoe", nullable = false)
    private String examType;

    @ManyToOne
    @JoinColumn(name = "pacient_id")
    private PacientModel pacientModel;

    @ManyToOne
    @JoinColumn(name = "consultation_id")
    private Consultation consultation;

    @CreationTimestamp
    private LocalDateTime created;
}