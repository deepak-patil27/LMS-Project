package com.bridgelabz.candidatehiringservice.entity;

import com.bridgelabz.candidatehiringservice.dto.CandidateDTO;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@NoArgsConstructor
@Data
@Table(name="CandidateDetails")
public class Candidate {
    @Id
    @GeneratedValue

    private Integer candidateID;
    private String firstName;
    private String middleName;
    private String lastName;
    private String email;
    private String password;
    private String mobileNum;
    private String hiredCity;
    private String hiredDate;
    private String degree;
    private String hiredLab;
    private String attitudeRemark;
    private String communicationRemark;
    private String knowledgeRemark;
    private String onboardingStatus;
    private Boolean status;
    private String creatoruser;
    private String joinDate;
    private String location;
    private double aggrper;
    private int currentPincode;
    private int permanentPincode;

    public Candidate(CandidateDTO dto) {
        this.firstName = dto.getFirstName();
        this.middleName = dto.getMiddleName();
        this.lastName = dto.getLastName();
        this.mobileNum = dto.getMobileNum();
        this.email = dto.getEmail();
        this.password = dto.getPassword();
        this.hiredCity = dto.getHiredCity();
        this.hiredDate = dto.getHiredDate();
        this.aggrper = dto.getAggrper();
        this.attitudeRemark = dto.getAttitudeRemark();
        this.communicationRemark = dto.getCommunicationRemark();
        this.creatoruser = dto.getCreatoruser();
        this.currentPincode = dto.getCurrentPincode();
        this.degree = dto.getDegree();
        this.knowledgeRemark = dto.getKnowledgeRemark();
        this.hiredLab = dto.getHiredLab();
        this.location = dto.getLocation();
        this.onboardingStatus = dto.getOnboardingStatus();
        this.permanentPincode = dto.getPermanentPincode();
       // this.status = dto.getStatus();
        this.joinDate = dto.getJoinDate();
    }

    public Candidate(Integer candidateID, CandidateDTO dto) {
        this.candidateID=candidateID;
        this.firstName = dto.getFirstName();
        this.middleName = dto.getMiddleName();
        this.lastName = dto.getLastName();
        this.mobileNum = dto.getMobileNum();
        this.email = dto.getEmail();
        this.password = dto.getPassword();
        this.hiredCity = dto.getHiredCity();
        this.hiredDate = dto.getHiredDate();
        this.aggrper = dto.getAggrper();
        this.attitudeRemark = dto.getAttitudeRemark();
        this.communicationRemark = dto.getCommunicationRemark();
        this.creatoruser = dto.getCreatoruser();
        this.currentPincode = dto.getCurrentPincode();
        this.degree = dto.getDegree();
        this.knowledgeRemark = dto.getKnowledgeRemark();
        this.hiredLab = dto.getHiredLab();
        this.location = dto.getLocation();
        this.onboardingStatus = dto.getOnboardingStatus();
        this.permanentPincode = dto.getPermanentPincode();
        //this.status = dto.getStatus();
        this.joinDate = dto.getJoinDate();
    }


}
