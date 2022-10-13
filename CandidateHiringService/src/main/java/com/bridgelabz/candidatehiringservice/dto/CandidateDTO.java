package com.bridgelabz.candidatehiringservice.dto;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

@Data
public class CandidateDTO {
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

    @NotEmpty(message = "mobile cant be empty")
    private String mobileNum;

    @NotEmpty(message = "hiredCity cant be empty")
    private String hiredCity;

    @NotEmpty(message = "hiredDate cant be empty")
    private String hiredDate;

    @NotEmpty(message = "Degree cant be empty")
    private String degree;

    @NotEmpty(message = "hiredLab cant be empty")
    private String hiredLab;

    @NotEmpty(message = "attitudeRemark cant be empty")
    private String attitudeRemark;

    @NotEmpty(message = "communicationRemark cant be empty")
    private String communicationRemark;

    @NotEmpty(message = "knowledgeRemark cant be empty")
    private String knowledgeRemark;

    @NotEmpty(message = "onboardingStatus cant be empty")
    private String onboardingStatus;

    @NotEmpty(message = "status cant be empty")
    private String status;

    @NotEmpty(message = "creatoruser cant be empty")
    private String creatoruser;

    @NotEmpty(message = "joinDate cant be empty")
    private String joinDate;

    @NotEmpty(message = "location cant be empty")
    private String location;

    @NotNull(message = "aggrper cant be empty")
    private double aggrper;

    @NotNull(message = "currentPincode cant be empty")
    private int currentPincode;

    @NotNull(message = "permanentPincode cant be empty")
    private int permanentPincode;


}
