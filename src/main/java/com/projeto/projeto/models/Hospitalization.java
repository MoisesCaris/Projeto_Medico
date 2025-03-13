package com.projeto.projeto.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;
import java.util.UUID;

@Data
@Entity(name = "hospitalization")
@AllArgsConstructor
@NoArgsConstructor
public class Hospitalization {

    @Id
    @GeneratedValue(generator = "UUID")
    private UUID id;

    @Column(name = "hospitalization_date", nullable = false)
    private LocalDateTime hospitalizationDate;

    @Column(name = "hospitalization_exit",nullable = true)
    private LocalDateTime hospitalizationExit;

    @Column(name = "reaseon_hospitalization",nullable = false)
    private String hospitalizationReason;

    @ManyToOne
    @JoinColumn(name = "pacient_id")
    private PacientModel pacientModel;

    @OneToOne
    @JoinColumn(name = "hospita_id")
    private HospitalModel hospitalModel;

    @CreationTimestamp
    private LocalDateTime created;
}