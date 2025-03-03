package com.projeto.projeto.controller;

import com.projeto.projeto.DTO.exam.ExamRegisterDTO;
import com.projeto.projeto.service.ExamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/exams")
public class ExamController {

    @Autowired
    private ExamService examService;

    @PostMapping("/register")
    public ResponseEntity registerExam(@RequestBody ExamRegisterDTO data){
        examService.examRegister(data);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
}
