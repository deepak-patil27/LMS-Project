package com.bridgelabz.candidateonboardingservice.entity;

import com.bridgelabz.candidateonboardingservice.dto.CandidateOnboardingDTO;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDate;

@Entity
@NoArgsConstructor
@Data
@Table(name="CandidateOnboarding")
public class CandidateOnboarding {

    @Id
    @GeneratedValue

    private int candidateID;
    private String firstName;
    private String middleName;
    private String lastName;
    private String email;
    private String password;
    private String mobileNum;
    private String hiredCity;
    private String parentName;
    private String parentMobile;
    private String temporaryAddress;
    private String parentOccupation;
    private String parentAnnualSalary;
    private String permanentAddress;
    private String profileImage;
    private String folderID;
    private String status;
    private String bankInfo;
    private String qualificationInfo;
    private LocalDate date = LocalDate.now();

    public CandidateOnboarding(CandidateOnboardingDTO dto) {
        this.firstName = dto.getFirstName();
        this.middleName = dto.getMiddleName();
        this.lastName = dto.getLastName();
        this.mobileNum = dto.getMobileNum();
        this.email = dto.getEmail();
        this.password = dto.getPassword();
        this.hiredCity = dto.getHiredCity();
        this.bankInfo = dto.getBankInfo();
        this.email = dto.getEmail();
        this.hiredCity = dto.getHiredCity();
        this.parentAnnualSalary = dto.getParentAnnualSalary();
        this.folderID = dto.getFolderID();
        this.parentMobile = dto.getParentMobile();
        this.parentName = dto.getParentName();
        this.parentOccupation = dto.getParentOccupation();
        this.temporaryAddress = dto.getTemporaryAddress();
        this.permanentAddress = dto.getPermanentAddress();
        this.profileImage = dto.getProfileImage();
        this.status = dto.getStatus();
        this.qualificationInfo = dto.getQualificationInfo();
    }

    public CandidateOnboarding(Integer candidateID, String firstName, String middleName, String lastName, String email, String password, String mobileNum, String hiredCity, String parentName, String parentMobile, String temporaryAddress, String parentOccupation, String parentAnnualSalary, String permanentAddress, String profileImage, String folderID, String status, String bankInfo, String qualificationInfo) {
        this.candidateID = candidateID;
        this.firstName = firstName;
        this.middleName = middleName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
        this.mobileNum = mobileNum;
        this.hiredCity = hiredCity;
        this.parentName = parentName;
        this.parentMobile = parentMobile;
        this.temporaryAddress = temporaryAddress;
        this.parentOccupation = parentOccupation;
        this.parentAnnualSalary = parentAnnualSalary;
        this.permanentAddress = permanentAddress;
        this.profileImage = profileImage;
        this.folderID = folderID;
        this.status = status;
        this.bankInfo = bankInfo;
        this.qualificationInfo = qualificationInfo;
    }
}
