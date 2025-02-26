package com.projeto.projeto.controller;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/doctor")
public class DoctorController {

    @PostMapping("/registerdoctor")
    public ResponseEntity<String> registerDoctor(HttpServletRequest request) {
        return ResponseEntity.ok().body("Doctor registered Successfully");
    }
}
