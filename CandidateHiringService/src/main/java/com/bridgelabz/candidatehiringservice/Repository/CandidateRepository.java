package com.bridgelabz.candidatehiringservice.Repository;

import com.bridgelabz.candidatehiringservice.entity.Candidate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface CandidateRepository extends JpaRepository<Candidate, Integer> {

    @Query(value="select * from Candidate_Details where email =:mail",nativeQuery = true)
    public Optional<Candidate> findByMail(String mail);
}
