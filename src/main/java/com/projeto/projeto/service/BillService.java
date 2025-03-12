package com.projeto.projeto.service;

import com.projeto.projeto.DTO.bill.BillDependecies;
import com.projeto.projeto.DTO.bill.CompletePayment;
import com.projeto.projeto.DTO.bill.PacientFindDTO;
import com.projeto.projeto.DTO.bill.RegisterBillDTO;
import com.projeto.projeto.mappers.BillMapper;
import com.projeto.projeto.models.Bill;
import com.projeto.projeto.repository.BillRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

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
        BillDependecies dependecies = getBillDependecies(data);
        Bill bill = mapper.billRegister(data, dependecies.pacientModel());
        this.billRepository.save(bill);
    }

    public Bill getBill(UUID id) {

        return this.billRepository.findById(id).orElseThrow();
    }

    public List<Bill> getBills() {

        return this.billRepository.findAll();
    }

    public Object completePayment(CompletePayment data, UUID id){
        var date = LocalDateTime.now();
        Bill existingBill =  getBill(id);
        mapper.completePayment(existingBill,data, date);
        return this.billRepository.save(existingBill);
    }

    public List<PacientFindDTO> getBillByPacientID(UUID pacientID){
        return billRepository.findByPacient(pacientID);
    }

    public List<PacientFindDTO> getBillNotPayByPacientID(UUID pacientID){
        return billRepository.findStatusOpen(pacientID);
    }

    public List<PacientFindDTO> getBillPayByPacientID(UUID pacientID){
        return billRepository.findStatusClose(pacientID);
    }
}
