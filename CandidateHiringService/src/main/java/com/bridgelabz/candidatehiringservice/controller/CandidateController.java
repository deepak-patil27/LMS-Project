package com.bridgelabz.candidatehiringservice.controller;

import com.bridgelabz.candidatehiringservice.dto.CandidateDTO;
import com.bridgelabz.candidatehiringservice.dto.ChangePasswordDTO;
import com.bridgelabz.candidatehiringservice.dto.LoginDTO;
import com.bridgelabz.candidatehiringservice.dto.ResponseDTO;
import com.bridgelabz.candidatehiringservice.service.ICandidateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@CrossOrigin
@RestController
@RequestMapping("/candidatedetails")
public class CandidateController {
    @Autowired
    private ICandidateService candidateService;

    //Ability to call api to register user
    //localhost:8081/user/add
    @PostMapping("/register")
    public ResponseEntity<String> registerCandidate(@Valid @RequestBody CandidateDTO candidateDTO) {
        ResponseDTO responseDTO = new ResponseDTO("Candidate Record created successfully", candidateService.registerCandidate(candidateDTO));
        return new ResponseEntity(responseDTO, HttpStatus.CREATED);
    }

    @GetMapping("/verify/{token}")
    public Boolean verify(@PathVariable String token){
        return candidateService.verify(token);
    }

    //Ability to call api to retrieve all user records
    //localhost:8081/user/getAll
    @GetMapping("/retrieveAll")
    public ResponseEntity<ResponseDTO> getAllRecords(){
        ResponseDTO dto = new ResponseDTO("All records get successfully",candidateService.getAllRecords());
        return new ResponseEntity<>(dto, HttpStatus.OK);
    }

    //Ability to call api to get user record by id
    //localhost:8081/user/get/{id}
    @GetMapping("/retrieve/{id}")
    public ResponseEntity<ResponseDTO> getRecord(@PathVariable Integer id){
        ResponseDTO dto = new ResponseDTO("Record get successfully",candidateService.getRecord(id));
        return new ResponseEntity<>(dto,HttpStatus.OK);
    }
    //Ability to call api to get token if forgot password
    //localhost:8081/user/getToken/{email}
    @GetMapping("/retrieveByToken/{email}")
    public ResponseEntity<ResponseDTO> getToken(@PathVariable String email){
        ResponseDTO dto = new ResponseDTO("Token for mail id sent on mail successfully",candidateService.getToken(email));
        return new ResponseEntity<>(dto,HttpStatus.OK);
    }

    //Ability to call api to get user record by token
    //localhost:8081/user/getByToken/{token}
    @GetMapping("/retrieveByToken/{token}")
    public ResponseEntity<ResponseDTO> getRecordByToken(@PathVariable String token){
        ResponseDTO dto = new ResponseDTO("Record get successfully",candidateService.getRecordByToken(token));
        return new ResponseEntity<>(dto,HttpStatus.OK);
    }

    //Ability to call api to update user record by id
    //localhost:8081/user/update/{id}
    @PutMapping("/update/{id}")
    public ResponseEntity<ResponseDTO> updateRecord(@PathVariable Integer id, @Valid @RequestBody CandidateDTO candidatedto){
        ResponseDTO dto = new ResponseDTO("Record updated successfully",candidateService.updateRecord(id,candidatedto));
        return new ResponseEntity<>(dto,HttpStatus.ACCEPTED);
    }

    //Ability to call api to login user
    //localhost:8081/user/login
    @PostMapping("/login")
    public ResponseEntity<ResponseDTO> userLogin(@Valid @RequestBody LoginDTO logindto){
        ResponseDTO dto = new ResponseDTO("Candidate logged in successfully",candidateService.candidateLogin(logindto));
        return new ResponseEntity<>(dto,HttpStatus.OK);
    }

    //Ability to call api to change password
    //localhost:8081/user/changepassword
    @PutMapping("/changepassword")
    public ResponseEntity<ResponseDTO> changePassword(@Valid @RequestBody ChangePasswordDTO passwordDTO){
        ResponseDTO dto = new ResponseDTO("Password changed successfully",candidateService.changePassword(passwordDTO));
        return new ResponseEntity<>(dto,HttpStatus.OK);
    }
}
