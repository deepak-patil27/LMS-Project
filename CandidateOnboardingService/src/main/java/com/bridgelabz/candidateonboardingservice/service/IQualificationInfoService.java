package com.bridgelabz.candidateonboardingservice.service;

import com.bridgelabz.candidateonboardingservice.dto.BankInfoDTO;
import com.bridgelabz.candidateonboardingservice.dto.QualificationInfoDTO;
import com.bridgelabz.candidateonboardingservice.entity.BankInfo;
import com.bridgelabz.candidateonboardingservice.entity.QualificationInfo;

public interface IQualificationInfoService {

    public QualificationInfo addQualificationDetails(QualificationInfoDTO qualificationInfodto);
}
