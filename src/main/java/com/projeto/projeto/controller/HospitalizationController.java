package com.projeto.projeto.controller;

import com.projeto.projeto.DTO.hospital.RegisterHospitalDTO;
import com.projeto.projeto.DTO.hospitalization.HospitalizationCreateDTO;
import com.projeto.projeto.models.Hospitalization;
import com.projeto.projeto.service.HospitalizationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/hospitalization")
public class HospitalizationController {

    @Autowired
    private HospitalizationService hospitalizationService;

    @PostMapping("/register")
    public ResponseEntity<Hospitalization> register(@RequestBody HospitalizationCreateDTO data) {
        hospitalizationService.createHospitalization(data);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @PatchMapping("/exit/{id}")
    public ResponseEntity<Hospitalization> exit(@PathVariable UUID id) {
        hospitalizationService.endHospitalization(id);
        return ResponseEntity.status(HttpStatus.OK).build();
    }
}
