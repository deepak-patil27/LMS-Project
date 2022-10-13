package com.bridgelabz.candidatehiringservice.service;

import com.bridgelabz.candidatehiringservice.dto.CandidateDTO;
import com.bridgelabz.candidatehiringservice.dto.ChangePasswordDTO;
import com.bridgelabz.candidatehiringservice.dto.LoginDTO;
import com.bridgelabz.candidatehiringservice.entity.Candidate;

import java.util.List;

public interface ICandidateService {

    public String registerCandidate(CandidateDTO candidatedto);

    public List<Candidate> getAllRecords();

    public Candidate getRecord(Integer id);

    public String getToken(String email);

    public Candidate getRecordByToken(String token);

    public Candidate updateRecord(Integer id, CandidateDTO dto);
    public Candidate statusRecord(Integer id, CandidateDTO dto);
    public Candidate candidateLogin(LoginDTO logindto);

    public Candidate changePassword(ChangePasswordDTO dto);

    Boolean verify (String token);
}
