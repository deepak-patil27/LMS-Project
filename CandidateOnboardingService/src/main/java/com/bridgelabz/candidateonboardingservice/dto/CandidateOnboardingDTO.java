package com.bridgelabz.candidateonboardingservice.dto;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;

@Data
public class CandidateOnboardingDTO {

    private int candidateID;

    @NotEmpty(message = "First name cant be empty")
    @Pattern(regexp = "^[A-Z]{1}[a-zA-Z\\s]{2,}$", message = "FirstName is Invalid")
    private String firstName;

    @NotEmpty(message = "Last name cant be empty")
    @Pattern(regexp = "^[A-Z]{1}[a-zA-Z\\s]{2,}$", message = "LastName is Invalid")
    private String middleName;

    @NotEmpty(message = "Last name cant be empty")
    @Pattern(regexp = "^[A-Z]{1}[a-zA-Z\\s]{2,}$", message = "LastName is Invalid")
    private String lastName;

    @NotEmpty(message = "Email cant be empty")
    @Pattern(regexp = "^[\\w+-]+(\\.[\\w-]+)*@[^_\\W]+(\\.[^_\\W]+)?(?=(\\.[^_\\W]{3,}$|\\.[a-zA-Z]{2}$)).*$", message = "Please enter a valid email id")
    private String email;

    @NotBlank(message = "Password cant be empty")
    private String password;

    @NotEmpty(message = "mobileNum cant be empty")
    private String mobileNum;

    @NotEmpty(message = "hiredCity cant be empty")
    private String hiredCity;

    @NotEmpty(message = "parentName cant be empty")
    private String parentName;

    @NotEmpty(message = "parentMobile cant be empty")
    private String parentMobile;

    @NotEmpty(message = "temporaryAddress cant be empty")
    private String temporaryAddress;

    @NotEmpty(message = "parentOccupation cant be empty")
    private String parentOccupation;

    @NotEmpty(message = "parentAnnualSalary cant be empty")
    private String parentAnnualSalary;

    @NotEmpty(message = "permanentAddress cant be empty")
    private String permanentAddress;

    @NotEmpty(message = "profileImage cant be empty")
    private String profileImage;

    @NotEmpty(message = "folderID cant be empty")
    private String folderID;

    @NotEmpty(message = "status cant be empty")
    private String status;

    @NotEmpty(message = "bankInfo cant be empty")
    private String bankInfo;

    @NotEmpty(message = "qualificationInfo cant be empty")
    private String qualificationInfo;

}
