package com.bridgelabz.candidatehiringservice.service;

import com.bridgelabz.candidatehiringservice.Repository.CandidateRepository;
import com.bridgelabz.candidatehiringservice.dto.CandidateDTO;
import com.bridgelabz.candidatehiringservice.dto.ChangePasswordDTO;
import com.bridgelabz.candidatehiringservice.dto.LoginDTO;
import com.bridgelabz.candidatehiringservice.entity.Candidate;
import com.bridgelabz.candidatehiringservice.exception.LmsException;
import com.bridgelabz.candidatehiringservice.util.EmailSenderService;
import com.bridgelabz.candidatehiringservice.util.TokenUtility;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@Service
@Slf4j
public class CandidateService implements ICandidateService {

    @Autowired
    CandidateRepository candidateRepo;

    @Autowired
    EmailSenderService mailService;

    @Autowired
    TokenUtility utility;

    public String registerCandidate(CandidateDTO candidatedto) {
        Candidate newCandidate = new Candidate(candidatedto);
        candidateRepo.save(newCandidate);
        String token = utility.createToken(newCandidate.getCandidateID());
        mailService.sendEmail(candidatedto.getEmail(), "Account Sign-up successfully. ", "Hello " + newCandidate.getFirstName() + " Your Account has been created. Your token is " + token + " Keep this token safe to access your account in future. ");
        return token;
    }

    public Boolean verify(String token){
        Integer id = utility.decodeToken(token);
        Optional<Candidate> user = candidateRepo.findById(id);
        if (user.isEmpty()) {
            return  true;
        }
        return false ;
    }



    //Ability to serve controller's user login api call
    public Candidate candidateLogin(LoginDTO logindto) {
        Optional<Candidate> newUser = candidateRepo.findByMail(logindto.getEmail());
        if (logindto.getEmail().equals(newUser.get().getEmail()) && logindto.getPassword().equals(newUser.get().getPassword())) {
            log.info("SuccessFully Logged In");
            return newUser.get();
        } else {

            throw new LmsException("User doesn't exists");

        }
    }

    //Ability to serve controller's get user record by token api call
    public Candidate getRecordByToken(String token) {
        Integer id = utility.decodeToken(token);
        Optional<Candidate> user = candidateRepo.findById(id);
        if (user.isEmpty()) {
            throw new LmsException("User Record doesn't exists");
        } else {
            log.info("Record retrieved successfully for given token having id " + id);
            return user.get();
        }
    }

    //Ability to serve controller's get token for changing password api call
    public String getToken(String email) {
        Optional<Candidate> user = candidateRepo.findByMail(email);
        String token = utility.createToken(user.get().getCandidateID());
        log.info("Token sent on mail successfully");
        return token;
    }

    //Ability to serve controller's get all user records api call
    public List<Candidate> getAllRecords() {
        List<Candidate> userList = candidateRepo.findAll();
        log.info("All Record Retrieved Successfully");
        return userList;
    }

    //Ability to serve controller's get user record by id api call
    public Candidate getRecord(Integer id) {
        Optional<Candidate> user = candidateRepo.findById(id);
        if (user.isEmpty()) {
            throw new LmsException("User Record doesn't exists");
        } else {
            log.info("Record retrieved successfully for id " + id);
            return user.get();
        }
    }
    //Ability to serve controller's cancel order record by id api call
    public Candidate statusRecord(Integer id, CandidateDTO dto) {
        Optional<Candidate> user = candidateRepo.findById(id);
        user.get().setStatus(true);
        candidateRepo.save(user.get());
        mailService.sendEmail(dto.getEmail(), "Status", "Hello,your status");
        return user.get();
    }

    //Ability to serve controller's update user record by id api call
    public Candidate updateRecord(Integer id, CandidateDTO dto) {
        Optional<Candidate> candidate = candidateRepo.findById(id);
        if (candidate.isEmpty()) {
            throw new LmsException("Candidate Record doesn't exists");
        } else {
            Candidate newCandidate = new Candidate(id, dto);
            candidateRepo.save(newCandidate);
            log.info("User data updated successfully");
            return newCandidate;
        }
    }



    //Ability to serve controller's change password api call
    public Candidate changePassword(@Valid @RequestBody ChangePasswordDTO dto) {
        Optional<Candidate> user = candidateRepo.findByMail(dto.getEmail());
        String generatedToken = utility.createToken(user.get().getCandidateID());
        mailService.sendEmail(user.get().getEmail(), "Welcome " + user.get().getFirstName(), generatedToken);
        if (user.isEmpty()) {
            throw new LmsException("User doesn't exists");
        } else {
            if (dto.getToken().equals(generatedToken)) {
                user.get().setPassword(dto.getNewPassword());
                candidateRepo.save(user.get());
                log.info("Password changes successfully");
                return user.get();
            } else {
                throw new LmsException("Invalid token");
            }
        }
    }





}
