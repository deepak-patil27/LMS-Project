package com.bridgelabz.candidateonboardingservice.repository;

import com.bridgelabz.candidateonboardingservice.entity.BankInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;


public interface BankInfoRepository extends JpaRepository<BankInfo, Integer> {
    @Query(value="select price from Bank_Info,CandidateOnboarding where CandidateOnboarding.candidateID=Bank_Info.candidateID and id =:id",nativeQuery = true)
    public Integer getBankInfoBy(int id);

}
