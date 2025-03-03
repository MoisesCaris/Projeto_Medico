package com.projeto.projeto.DTO.consultation;

import com.projeto.projeto.models.DoctorModel;
import com.projeto.projeto.models.PacientModel;

public record ConsultationDependecies(
        DoctorModel doctorModel,
        PacientModel pacientModel
){}
