package com.projeto.projeto.DTO.hospitalization;

import com.projeto.projeto.models.HospitalModel;
import com.projeto.projeto.models.PacientModel;

public record HospitalizationDependecies(
        PacientModel pacientModel,
        HospitalModel hospitalModel
) {
}
