package com.projeto.projeto.controller;

import com.projeto.projeto.DTO.consultation.RegisterConsultationDTO;
import com.projeto.projeto.DTO.doctor.DoctorRegisterDTO;
import com.projeto.projeto.service.DoctorService;
import jakarta.servlet.http.HttpServletRequest;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/doctor")
public class DoctorController {

    @Autowired
    private DoctorService doctorService;

    @PostMapping("/registerdoctor")
    public ResponseEntity register(@RequestBody DoctorRegisterDTO data) {
        doctorService.register(data);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @GetMapping("/get/doctor")
    public ResponseEntity getDoctor() {
        return ResponseEntity.status(HttpStatus.OK).body(doctorService.getAllDoctors());
    }
}
