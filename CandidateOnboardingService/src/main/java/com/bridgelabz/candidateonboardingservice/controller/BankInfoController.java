package com.bridgelabz.candidateonboardingservice.controller;

import com.bridgelabz.candidateonboardingservice.dto.BankInfoDTO;
import com.bridgelabz.candidateonboardingservice.dto.ResponseDTO;
import com.bridgelabz.candidateonboardingservice.service.IBankInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@CrossOrigin
@RestController
@RequestMapping("/bankInfoDetails")
public class BankInfoController {

    @Autowired
    IBankInfoService bankInfoService;

    @PostMapping("/add")
    public ResponseEntity<String> registerCandidate(@Valid @RequestBody BankInfoDTO bankInfoDTO) {
        ResponseDTO responseDTO = new ResponseDTO("Candidate Record created successfully", bankInfoService.addBankDetails(bankInfoDTO));
        return new ResponseEntity(responseDTO, HttpStatus.CREATED);
    }
}
