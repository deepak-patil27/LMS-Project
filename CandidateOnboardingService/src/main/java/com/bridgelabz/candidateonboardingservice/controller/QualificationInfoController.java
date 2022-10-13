package com.bridgelabz.candidateonboardingservice.controller;

import com.bridgelabz.candidateonboardingservice.dto.BankInfoDTO;
import com.bridgelabz.candidateonboardingservice.dto.QualificationInfoDTO;
import com.bridgelabz.candidateonboardingservice.dto.ResponseDTO;
import com.bridgelabz.candidateonboardingservice.service.IQualificationInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@CrossOrigin
@RestController
@RequestMapping("/QualificationInfoDetails")
public class QualificationInfoController {

    @Autowired
    IQualificationInfoService qualificationInfoService;

    @PostMapping("/add")
    public ResponseEntity<String> registerCandidate(@Valid @RequestBody QualificationInfoDTO qualificationInfoDTO) {
        ResponseDTO responseDTO = new ResponseDTO("Candidate Record created successfully", qualificationInfoService.addQualificationDetails(qualificationInfoDTO));
        return new ResponseEntity(responseDTO, HttpStatus.CREATED);
    }
}
