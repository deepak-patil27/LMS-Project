package com.bridgelabz.candidateonboardingservice.service;

import com.bridgelabz.candidateonboardingservice.dto.CandidateOnboardingDTO;
import com.bridgelabz.candidateonboardingservice.entity.CandidateOnboarding;
import com.bridgelabz.candidateonboardingservice.repository.CandidateOnboardingRepository;
import com.bridgelabz.candidateonboardingservice.util.EmailSenderService;
import com.bridgelabz.candidateonboardingservice.util.TokenUtility;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class CandidateOnboardingService implements ICandidateOnboardingService{

    @Autowired
    CandidateOnboardingRepository candidateOnboardingRepo;

    @Autowired
    EmailSenderService mailService;

    @Autowired
    TokenUtility utility;


    public String registerOnboardingCandidate(CandidateOnboardingDTO candidateOnboardingdto) {
        CandidateOnboarding newCandidateOnboarding = new CandidateOnboarding(candidateOnboardingdto);
        candidateOnboardingRepo.save(newCandidateOnboarding);
        String token = utility.createToken(newCandidateOnboarding.getCandidateID());
        mailService.sendEmail(candidateOnboardingdto.getEmail(), "Candidate registered successfully. ", "Hello " + newCandidateOnboarding.getFirstName() + " Your Account has been created. Your token is " + token);
        return token;
    }

}
