package com.projeto.projeto.service;

import com.projeto.projeto.DTO.bill.BillDependecies;
import com.projeto.projeto.DTO.bill.RegisterBillDTO;
import com.projeto.projeto.mappers.BillMapper;
import com.projeto.projeto.models.Bill;
import com.projeto.projeto.repository.BillRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

@Service
public class BillService {

    @Autowired
    private BillRepository billRepository;

    @Autowired
    private PacientService pacientService;

    @Autowired
    private BillMapper mapper;

    private BillDependecies getBillDependecies(RegisterBillDTO data) {
        return new BillDependecies(pacientService.getPacient(data.pacientID()));
    }

    public void registerBill(RegisterBillDTO data){
//        var date = LocalDateTime.now();
        BillDependecies dependecies = getBillDependecies(data);
        Bill bill = mapper.billRegister(data, dependecies.pacientModel());
        this.billRepository.save(bill);
    }
}
