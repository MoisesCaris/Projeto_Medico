package com.projeto.projeto.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import java.text.DecimalFormat;
import java.time.LocalDateTime;
import java.util.UUID;

@Data
@Entity(name = "bill")
@AllArgsConstructor
@NoArgsConstructor
public class Bill {

    @Id
    @GeneratedValue(generator = "UUID")
    private UUID id;

    @Column(name = "payment_date", nullable = true)
    private LocalDateTime paymentDate;

    @Column(nullable = false)
    private Double value;

    @Column(nullable = false)
    private String status;

    @ManyToOne
    @JoinColumn(name = "pacient_id")
    private PacientModel pacientModel;

    @CreationTimestamp
    private LocalDateTime created;
}