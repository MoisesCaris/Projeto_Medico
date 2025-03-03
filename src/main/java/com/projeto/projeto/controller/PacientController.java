package com.projeto.projeto.controller;

import com.projeto.projeto.DTO.pacient.PacientRegisterDTO;
import com.projeto.projeto.service.PacientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/pacient")
public class PacientController {

    @Autowired
    PacientService pacientService;

    @PostMapping("/register")
    public ResponseEntity regiterPacient(@RequestBody PacientRegisterDTO data){
        pacientService.registerPacient(data);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @GetMapping("/get/pacient")
    public ResponseEntity getPacient(){
        return ResponseEntity.status(HttpStatus.OK).body(pacientService.getAllPacients());
    }
}
