package com.bridgelabz.candidateonboardingservice.service;

import com.bridgelabz.candidateonboardingservice.dto.BankInfoDTO;
import com.bridgelabz.candidateonboardingservice.entity.BankInfo;

public interface IBankInfoService {

    public BankInfo addBankDetails(BankInfoDTO bankInfodto);
}
