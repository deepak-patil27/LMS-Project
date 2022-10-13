package com.bridgelabz.candidateonboardingservice.entity;

import com.bridgelabz.candidateonboardingservice.dto.BankInfoDTO;
import com.bridgelabz.candidateonboardingservice.dto.CandidateOnboardingDTO;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@NoArgsConstructor
@Data
@Table(name="BankInfo")
public class BankInfo {

    @Id
    @GeneratedValue

    private Integer bankInfoID;

    @OneToOne
    @JoinColumn(name="candidateID")

    private CandidateOnboarding candidateOnboarding;
    private String panNumber;
    private String aadharNumber;
    private String bankName;
    private String bankAccountNumber;
    private String ifscCode;
    private String passbookPath;
    private String panPath;
    private String aadharPath;

    private LocalDate date = LocalDate.now();


    public BankInfo(BankInfoDTO bankInfodto, CandidateOnboarding candidateOnboarding) {
        this.candidateOnboarding=candidateOnboarding;
        this.panNumber=bankInfodto.getPanNumber();
        this.aadharNumber=bankInfodto.getAadharNumber();
        this.bankName=bankInfodto.getBankName();
        this.bankAccountNumber=bankInfodto.getBankAccountNumber();
        this.ifscCode=bankInfodto.getIfscCode();
        this.passbookPath=bankInfodto.getPassbookPath();
        this.panPath=bankInfodto.getPanPath();
        this.aadharPath=bankInfodto.getAadharPath();
    }
}
