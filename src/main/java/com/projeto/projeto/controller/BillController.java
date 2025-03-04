package com.projeto.projeto.controller;

import com.projeto.projeto.DTO.bill.RegisterBillDTO;
import com.projeto.projeto.models.Bill;
import com.projeto.projeto.service.BillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/bill")
public class BillController {

    @Autowired
    private BillService billService;

    @PostMapping("/register")
    public ResponseEntity register(@RequestBody RegisterBillDTO data) {
        billService.registerBill(data);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
}
