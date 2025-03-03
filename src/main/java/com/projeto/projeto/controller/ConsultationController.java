package com.projeto.projeto.controller;

import com.projeto.projeto.DTO.consultation.RegisterConsultationDTO;
import com.projeto.projeto.service.ConsultationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/consultation")
public class ConsultationController {
    @Autowired
    private ConsultationService consultationService;

    @PostMapping("/register")
    public ResponseEntity register(@RequestBody RegisterConsultationDTO data) {
        consultationService.register(data);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

}
