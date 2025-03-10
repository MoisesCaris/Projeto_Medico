package com.projeto.projeto.controller;

import com.projeto.projeto.DTO.bill.CompletePayment;
import com.projeto.projeto.DTO.bill.RegisterBillDTO;
import com.projeto.projeto.models.Bill;
import com.projeto.projeto.service.BillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

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

    @GetMapping("/get/bill")
    public ResponseEntity getBill() {
        return ResponseEntity.status(HttpStatus.OK).body(billService.getBills());
    }

    @PatchMapping("/pay/{id}")
    public ResponseEntity pay(@PathVariable UUID id, @RequestBody CompletePayment data) {
        billService.completePayment(data,id);
        return ResponseEntity.status(HttpStatus.ACCEPTED).build();
    }

    @GetMapping("/get/{ID}")
    public ResponseEntity getBillById(@PathVariable UUID ID) {
        return ResponseEntity.status(HttpStatus.OK).body(billService.getBillByPacientID(ID));
    }
}
