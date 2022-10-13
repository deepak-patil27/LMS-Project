package com.bridgelabz.candidateonboardingservice.repository;

import com.bridgelabz.candidateonboardingservice.entity.BankInfo;
import com.bridgelabz.candidateonboardingservice.entity.QualificationInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface QualificationInfoRepository extends JpaRepository<QualificationInfo, Integer> {
    @Query(value="select * from Candidate_details where Candidateid =:id",nativeQuery=true)
    public List<QualificationInfo> findByCandidateID(Integer id);
}
