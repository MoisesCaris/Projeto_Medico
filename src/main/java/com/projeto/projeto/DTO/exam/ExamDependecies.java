package com.projeto.projeto.DTO.exam;

import com.projeto.projeto.models.Consultation;
import com.projeto.projeto.models.PacientModel;

public record ExamDependecies(
        PacientModel pacientModel,
        Consultation consultation
) {}
