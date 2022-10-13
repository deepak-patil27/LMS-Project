package com.bridgelabz.candidateonboardingservice.controller;

import com.bridgelabz.candidateonboardingservice.dto.CandidateOnboardingDTO;
import com.bridgelabz.candidateonboardingservice.dto.ResponseDTO;
import com.bridgelabz.candidateonboardingservice.service.ICandidateOnboardingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@CrossOrigin
@RestController
@RequestMapping("/candidateOnboardingDetails")
public class CandidateOnboardingController {

    @Autowired
    ICandidateOnboardingService candidateOnboardingService;

    @PostMapping("/register")
    public ResponseEntity<String> registerCandidate(@Valid @RequestBody CandidateOnboardingDTO candidateOnboardingDTO) {
        ResponseDTO responseDTO = new ResponseDTO("Candidate Record created successfully", candidateOnboardingService.registerOnboardingCandidate(candidateOnboardingDTO));
        return new ResponseEntity(responseDTO, HttpStatus.CREATED);
    }
}
