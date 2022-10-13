package com.bridgelabz.candidateonboardingservice.dto;

import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Data
public class BankInfoDTO {

    private Integer candidateID;

    @NotEmpty(message = "panNumber name cant be empty")
    private String panNumber;

    @NotEmpty(message = "aadharNumber name cant be empty")
    private String aadharNumber;

    @NotEmpty(message = "bankName name cant be empty")
    private String bankName;

    @NotEmpty(message = "bankAccountNumber name cant be empty")
    private String bankAccountNumber;

    @NotEmpty(message = "ifscCode name cant be empty")
    private String ifscCode;

    @NotEmpty(message = "passbookPath name cant be empty")
    private String passbookPath;

    @NotEmpty(message = "panPath name cant be empty")
    private String panPath;

    @NotEmpty(message = "aadharPath name cant be empty")
    private String aadharPath;


}
