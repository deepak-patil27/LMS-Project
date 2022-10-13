package com.bridgelabz.candidateonboardingservice.dto;

import lombok.Data;

import javax.validation.constraints.NotEmpty;

@Data
public class QualificationInfoDTO {

    private Integer candidateID;

    @NotEmpty(message = "diploma name cant be empty")
    private String diploma;

    @NotEmpty(message = "degree name cant be empty")
    private String degree;

    @NotEmpty(message = "field name cant be empty")
    private String field;

    @NotEmpty(message = "yearOfPassing name cant be empty")
    private String yearOfPassing;

    @NotEmpty(message = "finalPercentage name cant be empty")
    private String finalPercentage;

    @NotEmpty(message = "aggrPercentage name cant be empty")
    private String aggrPercentage;

    @NotEmpty(message = "enggCertificate name cant be empty")
    private String enggCertificate;

    @NotEmpty(message = "finalCertificate name cant be empty")
    private String finalCertificate;

    @NotEmpty(message = "trainingInstitute name cant be empty")
    private String trainingInstitute;

    @NotEmpty(message = "trainingDuration name cant be empty")
    private String trainingDuration;

    @NotEmpty(message = "course name cant be empty")
    private String course;

}
