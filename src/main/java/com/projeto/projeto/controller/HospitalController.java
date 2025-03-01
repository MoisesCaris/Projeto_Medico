package com.projeto.projeto.controller;

import com.projeto.projeto.DTO.hospital.HospitalNameChangeDTO;
import com.projeto.projeto.DTO.hospital.RegisterHospitalDTO;
import com.projeto.projeto.models.HospitalModel;
import com.projeto.projeto.repository.HospitalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.projeto.projeto.service.HospitalService;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/hospital")
public class HospitalController {

    @Autowired
    private HospitalService hospitalService;

    @Autowired
    private HospitalRepository hospitalRepository;

    @PostMapping("/register")
    public ResponseEntity register(@RequestBody RegisterHospitalDTO data) {
        var hospital = new HospitalModel(data.name(),data.address(),data.city(),data.state());
        this.hospitalRepository.save(hospital);
        return ResponseEntity.status(HttpStatus.CREATED).body(hospital);
    }

    @GetMapping("/take/{city}")
    public ResponseEntity<List<RegisterHospitalDTO>> getCity(@PathVariable String city) {
        return ResponseEntity.ok(hospitalService.getAllHospitalsByCity(city));
    }

    @GetMapping("/get/{state}")
    public ResponseEntity<List<RegisterHospitalDTO>> getState(@PathVariable String state) {
        return ResponseEntity.ok(hospitalService.getAllHospitalsByState(state));
    }

    @PatchMapping("/change/{ID}")
    public ResponseEntity<HospitalNameChangeDTO> change(@RequestBody HospitalNameChangeDTO data, @PathVariable UUID ID) {
        return ResponseEntity.ok((HospitalNameChangeDTO) hospitalService.hospitalNameChange(ID, data));
    }
}
