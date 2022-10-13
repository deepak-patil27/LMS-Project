package com.bridgelabz.candidateonboardingservice.entity;

import com.bridgelabz.candidateonboardingservice.dto.QualificationInfoDTO;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@NoArgsConstructor
@Data
@Table(name="QualificationInfo")
public class QualificationInfo {
    @Id
    @GeneratedValue

    private Integer qualificationInfoID;

    @OneToOne
    @JoinColumn(name="candidateID")

    private CandidateOnboarding candidateOnboarding;

    private String diploma;
    private String degree;
    private String field;
    private String yearOfPassing;
    private String finalPercentage;
    private String aggrPercentage;
    private String enggCertificate;
    private String finalCertificate;
    private String trainingInstitute;
    private String trainingDuration;
    private String course;


    public QualificationInfo(QualificationInfoDTO qualificationInfodto, CandidateOnboarding candidateOnboarding) {
        this.candidateOnboarding = candidateOnboarding;
        this.diploma = qualificationInfodto.getDiploma();
        this.degree = qualificationInfodto.getDegree();
        this.field = qualificationInfodto.getField();
        this.yearOfPassing = qualificationInfodto.getYearOfPassing();
        this.finalPercentage = qualificationInfodto.getFinalPercentage();
        this.aggrPercentage = qualificationInfodto.getAggrPercentage();
        this.enggCertificate = qualificationInfodto.getEnggCertificate();
        this.finalCertificate = qualificationInfodto.getFinalCertificate();
        this.trainingInstitute = qualificationInfodto.getTrainingInstitute();
        this.trainingDuration = qualificationInfodto.getTrainingDuration();
        this.course = qualificationInfodto.getCourse();
    }
}
