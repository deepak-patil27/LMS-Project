package com.bridgelabz.candidateonboardingservice.service;

import com.bridgelabz.candidateonboardingservice.dto.QualificationInfoDTO;
import com.bridgelabz.candidateonboardingservice.entity.CandidateOnboarding;
import com.bridgelabz.candidateonboardingservice.entity.QualificationInfo;
import com.bridgelabz.candidateonboardingservice.exception.LmsException;
import com.bridgelabz.candidateonboardingservice.repository.CandidateOnboardingRepository;
import com.bridgelabz.candidateonboardingservice.repository.QualificationInfoRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@Slf4j
public class QualificationInfoService implements IQualificationInfoService{

    @Autowired
    QualificationInfoRepository qualificationInfoRepo;

    @Autowired
    CandidateOnboardingRepository candidateOnboardingRepo;

    public QualificationInfo addQualificationDetails(QualificationInfoDTO qualificationInfodto) {
        Optional<CandidateOnboarding> candidateOnboarding = candidateOnboardingRepo.findById(qualificationInfodto.getCandidateID());
        if(candidateOnboarding.isPresent()) {
                QualificationInfo newQualificationInfo = new QualificationInfo(qualificationInfodto, candidateOnboarding.get());
                qualificationInfoRepo.save(newQualificationInfo);
                log.info("Qualification details inserted successfully");
                return newQualificationInfo;
            }else {
                throw new LmsException("Requested candidate is not available");
            }
        }




}
