package com.bridgelabz.candidateonboardingservice.service;

import com.bridgelabz.candidateonboardingservice.dto.BankInfoDTO;
import com.bridgelabz.candidateonboardingservice.entity.BankInfo;
import com.bridgelabz.candidateonboardingservice.entity.CandidateOnboarding;
import com.bridgelabz.candidateonboardingservice.entity.QualificationInfo;
import com.bridgelabz.candidateonboardingservice.exception.LmsException;
import com.bridgelabz.candidateonboardingservice.repository.BankInfoRepository;
import com.bridgelabz.candidateonboardingservice.repository.CandidateOnboardingRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@Slf4j
public class BankInfoService implements IBankInfoService{

    @Autowired
    BankInfoRepository bankRepo;

    @Autowired
    CandidateOnboardingRepository candidateOnboardingRepo;

    public BankInfo addBankDetails(BankInfoDTO bankInfodto) {
        Optional<CandidateOnboarding> candidateOnboarding = candidateOnboardingRepo.findById(bankInfodto.getCandidateID());
        if (candidateOnboarding.isPresent()) {
            BankInfo newBankInfo = new BankInfo(bankInfodto, candidateOnboarding.get());
            bankRepo.save(newBankInfo);
            log.info("Bank details inserted successfully");
            return newBankInfo;
        } else {
            throw new LmsException("Requested candidate is not available");
        }
    }
}
