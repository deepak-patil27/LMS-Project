package com.bridgelabz.admin.service;

import com.bridgelabz.admin.dto.ChangePasswordDTO;
import com.bridgelabz.admin.dto.LoginDTO;
import com.bridgelabz.admin.dto.UserDTO;
import com.bridgelabz.admin.entity.User;

import java.util.List;
public interface IUserService {
    public String registerUser(UserDTO userdto);

    public List<User> getAllRecords();

    public User getRecord(Integer id);

    public String getToken(String email);

    public User getRecordByToken(String token);

    public User updateRecord(Integer id, UserDTO dto);
    public User statusRecord(Integer id, UserDTO dto);
    public User userLogin(LoginDTO logindto);

    public User changePassword(ChangePasswordDTO dto);

    Boolean verify (String token);

}
